package com.diego.shoping_list.presentation.products

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.settings.SortModeRepository
import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.api.ProductInListInteractor
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.domain.model.ProductUnit
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.AddProductFormState
import com.diego.shoping_list.presentation.products.stateitems.ProductsEffect
import com.diego.shoping_list.presentation.products.stateitems.ProductsError
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import com.diego.shoping_list.presentation.products.stateitems.ProductsMenuEvent
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

    private val minQuantity = 1
    private val maxQuantity = 999

    init {
        observeProducts()
    }

    fun onIntent(intent: ProductsIntent) {
        when (intent) {
            ProductsIntent.AddProductClick -> onAddProductClick()
            ProductsIntent.DismissAddProduct -> onDismissAddProduct()
            ProductsIntent.ProductMenuClick -> onProductMenuClick()
            ProductsIntent.DismissProductMenu -> onDismissProductMenu()

            is ProductsIntent.AddProduct -> onAddProductEvent(intent.event)

            is ProductsIntent.Menu -> onProductMenuEvent(intent.event)

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

    // -----

    private fun onAddProductClick() {
        _state.update {
            it.copy(
                isAddSheetVisible = true,
                addForm = AddProductFormState()
            )
        }
    }

    private fun onDismissAddProduct() {
        _state.update {
            it.copy(
                isAddSheetVisible = false,
                addForm = AddProductFormState()
            )
        }
    }

    private fun onProductMenuClick() {
        _state.update {
            it.copy(
                isMenuSheetVisible = true
            )
        }
    }

    private fun onDismissProductMenu() {
        _state.update {
            it.copy(
                isMenuSheetVisible = false
            )
        }
    }

    // -----

    private fun onAddProductEvent(event: AddProductEvent) {
        when (event) {
            is AddProductEvent.NameChange -> onNameChange(event.value)
            is AddProductEvent.QuantityChange -> onQuantityChange(event.value)
            is AddProductEvent.UnitChange -> onUnitChange(event.value)
            is AddProductEvent.SuggestionSelected -> onSuggestionSelected(event.suggestion)
            is AddProductEvent.EditProduct -> onEditProduct(event.productId)
            AddProductEvent.Increment -> onIncrement()
            AddProductEvent.Decrement -> onDecrement()
            AddProductEvent.Submit -> submitProduct()
            AddProductEvent.Reset -> onResetForm()
        }
    }

    private fun onNameChange(value: String) {
        _state.update {
            it.copy(addForm = it.addForm.copy(name = value, nameError = null))
        }
    }

    private fun onQuantityChange(value: String) {
        val digits = value
            .filter { it.isDigit() }
            .take(maxQuantity.toString().length)
        _state.update {
            it.copy(addForm = it.addForm.copy(quantity = digits, quantityError = null))
        }
    }

    private fun onUnitChange(unit: ProductUnit) {
        _state.update {
            it.copy(addForm = it.addForm.copy(unit = unit))
        }
    }

    private fun onSuggestionSelected(suggestion: ProductSuggestion) {
        _state.update { state ->
            state.copy(
                addForm = state.addForm.copy(
                    name = suggestion.name,
                    unit = suggestion.defaultUnit
                )
            )
        }
    }

    private fun onEditProduct(productId: Long) {
        val fresh = _state.value.products.find { it.id == productId } ?: return
        _state.update {
            it.copy(
                isAddSheetVisible = true,
                addForm = AddProductFormState(
                    editingProduct = fresh,
                    name = fresh.name,
                    quantity = fresh.quantity.toString(),
                    unit = fresh.unit
                )
            )
        }
    }

    private fun onIncrement() {
        _state.update { state ->
            val current = state.addForm.quantity.toIntOrNull()
            val next = if (current == null) 1 else (current + 1).coerceAtMost(maxQuantity)
            state.copy(
                addForm = state.addForm.copy(
                    quantity = next.toString(),
                    quantityError = null
                )
            )
        }
    }

    private fun onDecrement() {
        _state.update { state ->
            val current = state.addForm.quantity.toIntOrNull() ?: return@update state
            val next = (current - 1).coerceIn(minQuantity, maxQuantity)
            state.copy(addForm = state.addForm.copy(quantity = next.toString()))
        }
    }

    private fun onResetForm() {
        _state.update { it.copy(addForm = AddProductFormState()) }
    }

    private fun submitProduct() {
        val form = _state.value.addForm

        val nameError = if (form.name.isBlank()) "Введите название" else null
        val qty = form.quantity.toIntOrNull()
        val quantityError = when {
            qty == null -> "Введите количество"
            qty !in minQuantity..maxQuantity -> "От $minQuantity до $maxQuantity"
            else -> null
        }

        if (nameError != null || quantityError != null) {
            _state.update {
                it.copy(
                    addForm = it.addForm.copy(
                        nameError = nameError,
                        quantityError = quantityError
                    )
                )
            }
            return
        }

        val qtyValue = qty ?: return

        _state.update { it.copy(addForm = it.addForm.copy(isSubmitting = true)) }

        viewModelScope.launch {
            try {
                val editing = form.editingProduct
                if (editing == null) {
                    interactor.addProduct(
                        listId = listId,
                        name = form.name,
                        quantity = qtyValue,
                        unit = form.unit
                    )
                } else {
                    interactor.updateProduct(
                        editing.copy(
                            name = form.name,
                            quantity = qtyValue,
                            unit = form.unit
                        )
                    )
                }
                _state.update {
                    it.copy(
                        isAddSheetVisible = false,
                        addForm = AddProductFormState(),
                    )
                }
                _effect.send(ProductsEffect.ShowToast(ProductsToast.ProductSaved))
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
                _state.update {
                    it.copy(addForm = it.addForm.copy(isSubmitting = false))
                }
                _effect.send(ProductsEffect.ShowError(ProductsError.SaveFailed))
            }
        }
    }

    // -----

    private fun onProductCheckedChange(product: Product, checked: Boolean) {
        viewModelScope.launch {
            try {
                interactor.updateChecked(product.id, checked)
            } catch (ce: CancellationException) {
                throw ce
            } catch (t: Throwable) {
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

    //  -----

    private fun onProductMenuEvent(event: ProductsMenuEvent) {
        when (event) {
            ProductsMenuEvent.DeleteAll -> {
                _state.update {
                    it.copy(
                        isMenuSheetVisible = false,
                        isDeleteAllDialogVisible = true
                    )
                }
            }

            ProductsMenuEvent.ClearChecked -> {
                _state.update {
                    it.copy(
                        isMenuSheetVisible = false,
                        isClearCheckedDialogVisible = true
                    )
                }
            }

            ProductsMenuEvent.ConfirmDeleteAll -> {
                _state.update { it.copy(isDeleteAllDialogVisible = false) }
                viewModelScope.launch {
                    try {
                        interactor.deleteAllInList(listId)
                    } catch (ce: CancellationException) {
                        throw ce
                    } catch (t: Throwable) {
                        _effect.send(ProductsEffect.ShowError(ProductsError.DeleteFailed))
                    }
                }
            }

            ProductsMenuEvent.DismissDeleteAllDialog -> {
                _state.update { it.copy(isDeleteAllDialogVisible = false) }
            }

            ProductsMenuEvent.ConfirmClearChecked -> {
                _state.update { it.copy(isClearCheckedDialogVisible = false) }
                viewModelScope.launch {
                    try {
                        interactor.deleteCheckedInList(listId)
                    } catch (ce: CancellationException) {
                        throw ce
                    } catch (t: Throwable) {
                        _effect.send(ProductsEffect.ShowError(ProductsError.DeleteFailed))
                    }
                }
            }

            ProductsMenuEvent.DismissClearCheckedDialog -> {
                _state.update { it.copy(isClearCheckedDialogVisible = false) }
            }

            ProductsMenuEvent.SortByAlphabet -> {
                onSortModeChange(SortMode.ALPHABETICAL)
                onDismissProductMenu()
            }

            ProductsMenuEvent.SortByUser -> {
                onSortModeChange(SortMode.MANUAL)
                onDismissProductMenu()
            }
        }
    }

    private fun onSortModeChange(mode: SortMode) {
        viewModelScope.launch { sortModeRepository.save(listId, mode) }
    }

    fun suggestionsFor(query: String): Flow<List<ProductSuggestion>> =
        if (query.isBlank()) flowOf(emptyList())
        else interactor.observeSuggestions(query)
}
