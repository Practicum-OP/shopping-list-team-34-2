package com.diego.shoping_list.presentation.products

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.database.repository.ProductInListRepository
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    savedStateHandle: SavedStateHandle,
    val repository: ProductInListRepository
) : ViewModel() {

    private val listId: Long = savedStateHandle.get<Long>("listId") ?: 0L

    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState: StateFlow<ProductsUiState> = _uiState.asStateFlow()

    private val minQuantity = 1
    private val maxQuantity = 999

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            repository.observeByList(listId).collectLatest { list ->
                _uiState.update { it.copy(products = list) }
            }
        }
    }

    fun suggestionsFor(query: String): Flow<List<ProductSuggestion>> =
        if (query.isBlank()) flowOf(emptyList())
        else repository.observeSuggestions(query)

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
                repository.addProduct(
                    listId = listId,
                    name = form.name,
                    quantity = qty!!,
                    unit = form.unit
                )
            } else {
                repository.updateProduct(
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
            repository.updateChecked(product.id, checked)
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
                    repository.deleteAllInList(listId)
                }
            }

            ProductsMenuEvent.DismissDeleteAllDialog -> {
                _uiState.update { it.copy(isDeleteAllDialogVisible = false) }
            }

            ProductsMenuEvent.ConfirmClearChecked -> {
                _uiState.update { it.copy(isClearCheckedDialogVisible = false) }
                viewModelScope.launch {
                    repository.deleteCheckedInList(listId)
                }
            }

            ProductsMenuEvent.DismissClearCheckedDialog -> {
                _uiState.update { it.copy(isClearCheckedDialogVisible = false) }
            }
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            repository.deleteProduct(product)
        }
    }
}

data class ProductsUiState(
    val products: List<Product> = emptyList(),
    val isAddSheetVisible: Boolean = false,
    val isMenuSheetVisible: Boolean = false,
    val isDeleteAllDialogVisible: Boolean = false,
    val isClearCheckedDialogVisible: Boolean = false,
    val addForm: AddProductFormState = AddProductFormState()
) {
    val isListEmpty: Boolean get() = products.isEmpty()
    val hasCheckedItems: Boolean get() = products.any { it.isChecked }
    val showEmptyPlaceholder: Boolean get() = products.isEmpty() && !isAddSheetVisible

    val canClearChecked: Boolean get() = hasCheckedItems
    val canDeleteAll: Boolean get() = !isListEmpty
}
