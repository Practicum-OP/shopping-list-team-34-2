package com.diego.shoping_list.presentation.shoppingList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShoppingListScreen(
    onShoppingListClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ShoppingListTopBar(
                onSearchClick = {},
                onDeleteClick = {},
                onToggleTheme = {},
            )
        },
        floatingActionButton = { ShoppingListFab(onClick = {}) },
    ) { innerPadding ->
        ShoppingListEmptyState(
            modifier = Modifier.padding(innerPadding)
        )
    }
}
