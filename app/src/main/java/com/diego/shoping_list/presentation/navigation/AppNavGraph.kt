package com.diego.shoping_list.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.diego.shoping_list.domain.interactor.AuthInteractor
import com.diego.shoping_list.presentation.auth.AuthScreen
import com.diego.shoping_list.presentation.products.ProductsScreen
import com.diego.shoping_list.presentation.shoppingList.ShoppingListScreen
import com.diego.shoping_list.presentation.start.StartDestination
import com.diego.shoping_list.presentation.start.StartScreen
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun AppNavGraph(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val authInteractor: AuthInteractor = koinInject()
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
    ) {
        composable(Screen.Start.route) {
            StartScreen(
                onFinished = { destination ->
                    val target = when (destination) {
                        StartDestination.MAIN -> Screen.Main.route
                        StartDestination.AUTH -> Screen.Auth.route
                    }

                    navController.navigate(target) {
                        popUpTo(Screen.Start.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Screen.Auth.route) {
            AuthScreen(onAuthSuccess = {
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Auth.route) { inclusive = true }
                }
            })
        }

        composable(Screen.Main.route) {
            ShoppingListScreen(
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme,
                onShoppingListClick = { listId ->
                    navController.navigate("products/${listId}")
                },
                onLogout = {
                    scope.launch {
                        authInteractor.logout()
                        navController.navigate(Screen.Auth.route) {
                            popUpTo(Screen.Main.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }

        composable(
            route = Screen.Products.route,
            arguments = listOf(navArgument("listId") { type = NavType.LongType })
        ) {
            ProductsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}