package com.diego.shoping_list.presentation.products.stateitems

import com.diego.shoping_list.domain.model.Product

sealed interface ProductsIntent {
    data object AddProductClick : ProductsIntent
    data object DismissAddProduct : ProductsIntent
    data object ProductMenuClick : ProductsIntent
    data object DismissProductMenu : ProductsIntent

    data class ProductCheckedChange(val product: Product, val checked: Boolean) : ProductsIntent
    data class DeleteProduct(val product: Product) : ProductsIntent
    data object ConfirmDeleteProduct : ProductsIntent
    data object DismissDeleteProduct : ProductsIntent
    data object DragStarted : ProductsIntent
    data object DragStopped : ProductsIntent
    data class ProductMove(val from: Int, val to: Int) : ProductsIntent

    data class AddProduct(val event: AddProductEvent) : ProductsIntent

    data class Menu(val event: ProductsMenuEvent) : ProductsIntent
}