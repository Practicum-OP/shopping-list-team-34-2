package com.diego.shoping_list.presentation.products

sealed interface ProductsMenuEvent {
    data object Sorting : ProductsMenuEvent
    data object DeleteAll : ProductsMenuEvent
    data object ClearChecked : ProductsMenuEvent
    data object ConfirmDeleteAll : ProductsMenuEvent
    data object DismissDeleteAllDialog : ProductsMenuEvent
    data object ConfirmClearChecked : ProductsMenuEvent
    data object DismissClearCheckedDialog : ProductsMenuEvent
}