package com.diego.shoping_list.presentation.products

import androidx.lifecycle.ViewModel
import com.diego.shoping_list.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductsViewModel(
) : ViewModel() {

    /*    private val demoProducts = listOf(
            Product(id = 5,  name = "Молоко", quantity = 2, unit = "л", isChecked = true),
            Product(id = 15, name = "Сыр",    quantity = 2, unit = "л", isChecked = true),
            Product(id = 11, name = "Мясо",   quantity = 2, unit = "л", isChecked = true)
        )*/

    private val demoProducts = emptyList<Product>()

    private val _uiState = MutableStateFlow(
        ProductsUiState(
            products = demoProducts,
            content = if (demoProducts.isEmpty()) {
                ProductScreenState.IsEmpty
            } else {
                ProductScreenState.ShowShoppingList
            }
        )
    )
    val uiState: StateFlow<ProductsUiState> = _uiState.asStateFlow()

    fun onAddProductClick() {
        _uiState.update { it.copy(isAddSheetVisible = true) }
    }

    fun onDismissAddProduct() {
        _uiState.update { it.copy(isAddSheetVisible = false) }
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
