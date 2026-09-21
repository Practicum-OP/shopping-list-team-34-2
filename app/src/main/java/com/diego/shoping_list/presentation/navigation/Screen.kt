package com.diego.shoping_list.presentation.navigation

sealed class Screen(val route: String) {
    object Start : Screen("start")
    object Main : Screen("main")
    object Products : Screen("products/{listId}")
}