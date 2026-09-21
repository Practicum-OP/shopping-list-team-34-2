package com.diego.shoping_list.presentation.shoppingList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShoppingListScreen(
    onShoppingListClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onToggleTheme: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ShoppingListTopBar(
                onSearchClick = onSearchClick,
                onDeleteClick = onDeleteClick,
                onToggleTheme = onToggleTheme,
            )
        },
        floatingActionButton = { ShoppingListFab(onClick = onAddClick) },
    ) { innerPadding ->
        ShoppingListEmptyState(
            modifier = Modifier.padding(innerPadding)
        )
    }
}
