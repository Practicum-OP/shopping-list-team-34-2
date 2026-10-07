package com.diego.shoping_list.presentation.products

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.settings.SortModeRepository
import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.api.ProductInListInteractor
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.AddProductFormState
import com.diego.shoping_list.presentation.products.stateitems.ProductsMenuEvent
import com.diego.shoping_list.presentation.products.stateitems.ProductsUiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    savedStateHandle: SavedStateHandle,
    private val interactor: ProductInListInteractor,
    private val sortModeRepository: SortModeRepository
) : ViewModel() {


    private val listId: Long = savedStateHandle.get<Long>("listId") ?: 0L

    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState: StateFlow<ProductsUiState> = _uiState.asStateFlow()

    private val minQuantity = 1
    private val maxQuantity = 999

    init {
        observeProducts()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeProducts() {
        sortModeRepository.sortMode(listId)
            .flatMapLatest { mode ->
                interactor.observeByList(listId, mode).map { it to mode }
            }
            .onEach { (list, mode) ->
                _uiState.update { state ->
                    if (state.isDragging) {
                        state.copy(sortMode = mode)
                    } else {
                        state.copy(products = list, sortMode = mode)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun onDragStarted() {
        _uiState.update { it.copy(isDragging = true) }
    }

    fun onDragStopped() {
        val ids = _uiState.value.products.map { it.id }
        _uiState.update { it.copy(isDragging = false) }
        viewModelScope.launch {
            interactor.saveOrder(listId, ids)
        }
    }

    fun onProductMove(from: Int, to: Int) {
        if (!_uiState.value.isManualSortMode) return
        val list = _uiState.value.products.toMutableList()
        list.add(to, list.removeAt(from))
        _uiState.update { it.copy(products = list) }
    }

    private fun onSortModeChange(mode: SortMode) {
        viewModelScope.launch { sortModeRepository.save(listId, mode) }
    }

    fun suggestionsFor(query: String): Flow<List<ProductSuggestion>> =
        if (query.isBlank()) flowOf(emptyList())
        else interactor.observeSuggestions(query)

    fun onAddProductClick() {
        _uiState.update {
            it.copy(
                isAddSheetVisible = true,
                addForm = AddProductFormState()
            )
        }
    }

    fun onDismissAddProduct() {
        _uiState.update {
            it.copy(
                isAddSheetVisible = false,
                addForm = AddProductFormState()
            )
        }
    }

    fun onAddProductEvent(event: AddProductEvent) {
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
        _uiState.update {
            it.copy(addForm = it.addForm.copy(name = value, nameError = null))
        }
    }

    private fun onQuantityChange(value: String) {
        val digits = value
            .filter { it.isDigit() }
            .take(maxQuantity.toString().length)
        _uiState.update {
            it.copy(addForm = it.addForm.copy(quantity = digits, quantityError = null))
        }
    }

    private fun onUnitChange(unit: String) {
        _uiState.update {
            it.copy(addForm = it.addForm.copy(unit = unit))
        }
    }

    private fun onSuggestionSelected(suggestion: ProductSuggestion) {
        _uiState.update { state ->
            state.copy(
                addForm = state.addForm.copy(
                    name = suggestion.name,
                    unit = suggestion.defaultUnit
                )
            )
        }
    }

    private fun onEditProduct(productId: Long) {
        val fresh = _uiState.value.products.find { it.id == productId } ?: return
        _uiState.update {
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
        _uiState.update { state ->
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
        _uiState.update { state ->
            val current = state.addForm.quantity.toIntOrNull() ?: return@update state
            val next = (current - 1).coerceIn(minQuantity, maxQuantity)
            state.copy(addForm = state.addForm.copy(quantity = next.toString()))
        }
    }

    private fun onResetForm() {
        _uiState.update { it.copy(addForm = AddProductFormState()) }
    }

    private fun submitProduct() {
        val form = _uiState.value.addForm

        val nameError = if (form.name.isBlank()) "Введите название" else null
        val qty = form.quantity.toIntOrNull()
        val quantityError = when {
            qty == null -> "Введите количество"
            qty !in minQuantity..maxQuantity -> "От $minQuantity до $maxQuantity"
            else -> null
        }

        if (nameError != null || quantityError != null) {
            _uiState.update {
                it.copy(
                    addForm = it.addForm.copy(
                        nameError = nameError,
                        quantityError = quantityError
                    )
                )
            }
            return
        }

        _uiState.update { it.copy(addForm = it.addForm.copy(isSubmitting = true)) }

        viewModelScope.launch {
            val editing = form.editingProduct
            if (editing == null) {
                interactor.addProduct(
                    listId = listId,
                    name = form.name,
                    quantity = qty!!,
                    unit = form.unit
                )
            } else {
                interactor.updateProduct(
                    editing.copy(
                        name = form.name,
                        quantity = qty!!,
                        unit = form.unit
                    )
                )
            }
        }

        _uiState.update {
            it.copy(
                isAddSheetVisible = false,
                addForm = AddProductFormState()
            )
        }

    }

    fun onProductCheckedChange(product: Product, checked: Boolean) {
        viewModelScope.launch {
            interactor.updateChecked(product.id, checked)
        }
    }

    fun onProductsMenuClick() {
        _uiState.update {
            it.copy(
                isMenuSheetVisible = true
            )
        }
    }

    fun onDismissMenuProduct() {
        _uiState.update {
            it.copy(
                isMenuSheetVisible = false
            )
        }
    }

    fun onProductsMenuEvent(event: ProductsMenuEvent) {
        when (event) {
            ProductsMenuEvent.Sorting -> {}

            ProductsMenuEvent.DeleteAll -> {
                _uiState.update {
                    it.copy(
                        isMenuSheetVisible = false,
                        isDeleteAllDialogVisible = true
                    )
                }
            }

            ProductsMenuEvent.ClearChecked -> {
                _uiState.update {
                    it.copy(
                        isMenuSheetVisible = false,
                        isClearCheckedDialogVisible = true
                    )
                }
            }

            ProductsMenuEvent.ConfirmDeleteAll -> {
                _uiState.update { it.copy(isDeleteAllDialogVisible = false) }
                viewModelScope.launch {
                    interactor.deleteAllInList(listId)
                }
            }

            ProductsMenuEvent.DismissDeleteAllDialog -> {
                _uiState.update { it.copy(isDeleteAllDialogVisible = false) }
            }

            ProductsMenuEvent.ConfirmClearChecked -> {
                _uiState.update { it.copy(isClearCheckedDialogVisible = false) }
                viewModelScope.launch {
                    interactor.deleteCheckedInList(listId)
                }
            }

            ProductsMenuEvent.DismissClearCheckedDialog -> {
                _uiState.update { it.copy(isClearCheckedDialogVisible = false) }
            }

            ProductsMenuEvent.SortByAlphabet -> {
                onSortModeChange(SortMode.ALPHABETICAL)
                onDismissMenuProduct()
            }

            ProductsMenuEvent.SortByUser -> {
                onSortModeChange(SortMode.MANUAL)
                onDismissMenuProduct()
            }
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            interactor.deleteProduct(product)
        }
    }


}
