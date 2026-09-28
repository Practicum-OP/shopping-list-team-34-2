package com.diego.shoping_list.presentation.products

sealed interface ProductMenuState {
    object SortByDefault: ProductMenuState
    object SortByAlphabet: ProductMenuState
    object SortByUser: ProductMenuState
}