package com.diego.shoping_list.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.diego.shoping_list.presentation.products.ProductsScreen
import com.diego.shoping_list.presentation.start.StartScreen
import com.diego.shoping_list.ui.main.MainScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.Start.route
    ) {
        composable(Screen.Start.route) {
            StartScreen(
                onFinished = {
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Start.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Main.route) {
            MainScreen( onShoppingListClick = { listId ->
                navController.navigate("products/${listId}")})
        }
        composable(
            route = Screen.Products.route,
            arguments = listOf(navArgument("listId") { type = NavType.LongType })
        ) { backStackEntry ->
            val listId = backStackEntry.arguments?.getLong("listId") ?: 0L
            ProductsScreen(
                listId = listId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}