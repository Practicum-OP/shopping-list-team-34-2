package com.diego.shoping_list.presentation.products.stateitems

sealed interface ProductsEffect {
    data class ShowError(val error: ProductsError) : ProductsEffect
    data class ShowToast(val toast: ProductsToast) : ProductsEffect
}

enum class ProductsError {
    SaveFailed,
    DeleteFailed,
    SaveOrderFailed,
    Unknown,
}

enum class ProductsToast {
    ProductSaved,
    ProductDeleted,
}