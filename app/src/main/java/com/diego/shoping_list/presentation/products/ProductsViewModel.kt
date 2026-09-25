package com.diego.shoping_list.presentation.products

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.database.repository.ProductInListRepository
import com.diego.shoping_list.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    savedStateHandle: SavedStateHandle,
    val repository: ProductInListRepository
) : ViewModel() {

    private val listId: Long = savedStateHandle.get<Long>("listId") ?: 0L

    init {
        loadProducts()
    }

    private val _uiState = MutableStateFlow(ProductsUiState())

    val uiState: StateFlow<ProductsUiState> = _uiState.asStateFlow()

    private fun loadProducts() {
        viewModelScope.launch {
            repository.observeByList(listId).collectLatest { list ->
                _uiState.update { state ->
                    state.copy(
                        products = list,
                        content = if (list.isEmpty()) {
                            ProductScreenState.IsEmpty
                        } else {
                            ProductScreenState.ShowShoppingList
                        }
                    )

                }
            }
        }
    }

    fun onAddProductClick() {
        _uiState.update { it.copy(isAddSheetVisible = true) }
    }

    fun onDismissAddProduct() {
        _uiState.update { it.copy(isAddSheetVisible = false) }
    }

    fun addProduct(name: String, quantity: Int, unit: String) {
        viewModelScope.launch {
            repository.addProduct(listId = listId, name = name, quantity = quantity, unit = unit)
        }
        _uiState.update { it.copy(isAddSheetVisible = false) }
    }

    fun editProduct(product: Product) {

    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            repository.deleteProduct(product)
        }
    }
}

sealed interface ProductScreenState {
    object IsEmpty : ProductScreenState
    object ShowShoppingList : ProductScreenState
}

data class ProductsUiState(
    val products: List<Product> = emptyList(),
    val content: ProductScreenState = ProductScreenState.IsEmpty,
    val isAddSheetVisible: Boolean = false
)
