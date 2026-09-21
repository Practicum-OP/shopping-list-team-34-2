package com.diego.shoping_list.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onToggleTheme: () -> Unit = {},
    onShoppingListClick: (Long) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MainTopBar(
                onSearchClick = onSearchClick,
                onDeleteClick = onDeleteClick,
                onToggleTheme = onToggleTheme,
            )
        },
        floatingActionButton = { MainFab(onClick = onAddClick) },
    ) { innerPadding ->
        MainEmptyState(
            modifier = Modifier.padding(innerPadding)
        )
    }
}
