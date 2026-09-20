package com.diego.shoping_list.presentation.navigation

sealed class Screen(val route: String) {
    object Start : Screen("start")
    object ShoppingList : Screen("shopping_list")
    object Products : Screen("products/{listId}")
    object TestDb : Screen("test_db")
}