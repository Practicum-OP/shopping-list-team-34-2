package com.diego.shoping_list.presentation.products

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.settings.SortModeRepository
import com.diego.shoping_list.domain.api.ProductInListInteractor
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.presentation.common.AppLogger
import com.diego.shoping_list.presentation.products.handlers.AddProductFormHandler
import com.diego.shoping_list.presentation.products.handlers.HandlerContext
import com.diego.shoping_list.presentation.products.handlers.ProductsMenuHandler
import com.diego.shoping_list.presentation.products.stateitems.ProductsEffect
import com.diego.shoping_list.presentation.products.stateitems.ProductsError
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import com.diego.shoping_list.presentation.products.stateitems.ProductsToast
import com.diego.shoping_list.presentation.products.stateitems.ProductsUiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class ProductsViewModel(
    savedStateHandle: SavedStateHandle,
    private val interactor: ProductInListInteractor,
    private val sortModeRepository: SortModeRepository
) : ViewModel() {

    private val listId: Long = savedStateHandle.get<Long>("listId") ?: 0L

    private val _state = MutableStateFlow(ProductsUiState())
    val state: StateFlow<ProductsUiState> = _state.asStateFlow()

    private val _effect = Channel<ProductsEffect>(Channel.BUFFERED)
    val effect: Flow<ProductsEffect> = _effect.receiveAsFlow()

    private val handlerContext = HandlerContext(
        scope = viewModelScope,
        readState = { _state.value },
        updateState = { transform -> _state.update(transform) },
        sendEffect = { effect -> _effect.send(effect) }
    )

    private val formHandler = AddProductFormHandler(
        interactor = interactor,
        listId = listId,
        context = handlerContext
    )

    private val menuHandler = ProductsMenuHandler(
        interactor = interactor,
        sortModeRepository = sortModeRepository,
        listId = listId,
        context = handlerContext
    )

    init {
        observeProducts()
    }

    fun onIntent(intent: ProductsIntent) {
        when (intent) {
            ProductsIntent.AddProductClick -> formHandler.onAddProductClick()
            ProductsIntent.DismissAddProduct -> formHandler.onDismissAddProduct()
            ProductsIntent.ProductMenuClick -> menuHandler.onProductMenuClick()
            ProductsIntent.DismissProductMenu -> menuHandler.onDismissProductMenu()

            is ProductsIntent.AddProduct -> formHandler.onAddProductEvent(intent.event)

            is ProductsIntent.Menu -> menuHandler.onProductMenuEvent(intent.event)

            is ProductsIntent.ProductCheckedChange ->
                onProductCheckedChange(intent.product, intent.checked)

            is ProductsIntent.DeleteProduct -> onDeleteProduct(intent.product)
            ProductsIntent.ConfirmDeleteProduct -> onConfirmDeleteProduct()
            ProductsIntent.DismissDeleteProduct -> onDismissDeleteProduct()
            ProductsIntent.DragStarted -> onDragStarted()
            ProductsIntent.DragStopped -> onDragStopped()
            is ProductsIntent.ProductMove -> onProductMove(intent.from, intent.to)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeProducts() {
        sortModeRepository.sortMode(listId)
            .flatMapLatest { mode ->
                interactor.observeByList(listId, mode).map { it to mode }
            }
            .onEach { (list, mode) ->
                _state.update { state ->
                    if (state.isDragging) {
                        state.copy(sortMode = mode)
                    } else {
                        state.copy(products = list, sortMode = mode)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun onProductCheckedChange(product: Product, checked: Boolean) {
        viewModelScope.launch {
            try {
                interactor.updateChecked(product.id, checked)
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                AppLogger.e(t, "updateChecked(\${product.id}, \$checked) failed")
                _effect.send(ProductsEffect.ShowError(ProductsError.Unknown))
            }
        }
    }

    private fun onDeleteProduct(product: Product) {
        _state.update {
            it.copy(
                isDeleteProductDialogVisible = true,
                productToDelete = product
            )
        }
    }

    private fun onConfirmDeleteProduct() {
        val product = _state.value.productToDelete ?: return
        _state.update {
            it.copy(
                isDeleteProductDialogVisible = false,
                productToDelete = null,
            )
        }
        viewModelScope.launch {
            try {
                interactor.deleteProduct(product)
                _effect.send(ProductsEffect.ShowToast(ProductsToast.ProductDeleted))
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                AppLogger.e(t, "deleteProduct(\${product.id}) failed")
                _effect.send(ProductsEffect.ShowError(ProductsError.DeleteFailed))
            }
        }
    }

    private fun onDismissDeleteProduct() {
        _state.update {
            it.copy(
                isDeleteProductDialogVisible = false,
                productToDelete = null
            )
        }
    }

    private fun onDragStarted() {
        _state.update { it.copy(isDragging = true) }
    }

    private fun onDragStopped() {
        val ids = _state.value.products.map { it.id }
        _state.update { it.copy(isDragging = false) }
        viewModelScope.launch {
            try {
                interactor.saveOrder(listId, ids)
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                AppLogger.e(t, "saveOrder(\${listId}) failed")
                _effect.send(ProductsEffect.ShowError(ProductsError.SaveOrderFailed))
            }
        }
    }

    private fun onProductMove(from: Int, to: Int) {
        if (!_state.value.isManualSortMode) return
        val list = _state.value.products.toMutableList()
        list.add(to, list.removeAt(from))
        _state.update { it.copy(products = list) }
    }

    fun suggestionsFor(query: String): Flow<List<ProductSuggestion>> =
        if (query.isBlank()) flowOf(emptyList())
        else interactor.observeSuggestions(query)
}
