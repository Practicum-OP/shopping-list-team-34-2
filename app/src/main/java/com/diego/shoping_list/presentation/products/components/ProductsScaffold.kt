package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.diego.shoping_list.R
import com.diego.shoping_list.presentation.common.AppBarIcon
import com.diego.shoping_list.presentation.common.AppTopBar
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListFab

@Composable
fun ProductsScaffold(
    snackbarHostState: SnackbarHostState,
    onBackClick: () -> Unit,
    onIntent: (ProductsIntent) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            AppTopBar(
                title = stringResource(R.string.product_screen_title),
                onBackClick = onBackClick,
                actions = {
                    IconButton(onClick = { onIntent(ProductsIntent.ProductMenuClick) }) {
                        AppBarIcon(
                            iconResId = R.drawable.ic_products_menu,
                            contentDescription = stringResource(R.string.products_menu_icon_description),
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            ShoppingListFab(onClick = { onIntent(ProductsIntent.AddProductClick) })
        },
        content = content
    )
}