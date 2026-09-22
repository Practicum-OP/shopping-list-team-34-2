package com.diego.shoping_list.presentation.shoppingList

import com.diego.shoping_list.domain.ShoppingList

sealed class UiState {
    data object Empty : UiState()
    data class Content(val shoppingLists: List<ShoppingList>) : UiState()
}
