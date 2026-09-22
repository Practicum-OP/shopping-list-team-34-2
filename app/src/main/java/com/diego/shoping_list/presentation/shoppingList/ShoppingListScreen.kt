package com.diego.shoping_list.presentation.shoppingList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.diego.shoping_list.R
import com.diego.shoping_list.presentation.common.DialogWindow
import com.diego.shoping_list.presentation.shoppingList.view_model.ShoppingListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShoppingListScreen(
    modifier: Modifier = Modifier,
    viewModel: ShoppingListViewModel = koinViewModel(),
    onShoppingListClick: (Long) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var showAddDialog by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ShoppingListTopBar(
                onSearchClick = {},
                onDeleteClick = {},
                onToggleTheme = {},
            )
        },
        floatingActionButton = { ShoppingListFab(onClick = { showAddDialog = true }) },
    ) { innerPadding ->
        when (val state = uiState) {
            is UiState.Empty -> ShoppingListEmptyState(
                modifier = Modifier.padding(innerPadding)
            )

            is UiState.Content -> ShoppingListContent(
                shoppingLists = state.shoppingLists,
                onShoppingListClick = onShoppingListClick,
                contentPadding = innerPadding
            )
        }
    }

    if (showAddDialog) {
        DialogWindow(
            title = stringResource(R.string.shopping_title_dialog),
            label = stringResource(R.string.shopping_edit_dialog),
            confirmText = stringResource(R.string.create_dialog),
            dismissText = stringResource(R.string.cancel_dialog),
            onDismiss = { showAddDialog = false },
            onConfirm = { name ->
                viewModel.insertList(name)
                showAddDialog = false
            },
            iconResId = R.drawable.ic_dialog,
            hint = stringResource(R.string.shopping_hint_dialog),
        )
    }
}
