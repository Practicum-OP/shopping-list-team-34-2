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
import com.diego.shoping_list.presentation.common.AppConfirmDialog
import com.diego.shoping_list.presentation.common.ConfirmDialog
import com.diego.shoping_list.presentation.common.DialogWindow
import com.diego.shoping_list.presentation.common.AppDialogWindow
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListContent
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListEmptyState
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListFab
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListIconSheet
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListSearchScreen
import com.diego.shoping_list.presentation.shoppingList.components.ShoppingListTopBar
import com.diego.shoping_list.presentation.shoppingList.state.UiState
import com.diego.shoping_list.presentation.shoppingList.view_model.ShoppingListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShoppingListScreen(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ShoppingListViewModel = koinViewModel(),
    onShoppingListClick: (Long) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var showAddDialog by rememberSaveable { mutableStateOf(false) }
    var showDeleteAllDialog by rememberSaveable { mutableStateOf(false) }
    var iconSheetListId by rememberSaveable { mutableStateOf<Long?>(null) }
    var isSearchActive by rememberSaveable { mutableStateOf(false) }

    if (isSearchActive) {
        val shoppingLists = when (val state = uiState) {
            is UiState.Content -> state.shoppingLists
            UiState.Empty -> emptyList()
        }

        ShoppingListSearchScreen(
            shoppingLists = shoppingLists,
            isDarkTheme = isDarkTheme,
            onClose = { isSearchActive = false },
            onShoppingListClick = onShoppingListClick,
            modifier = modifier
        )
        return
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ShoppingListTopBar(
                isDarkTheme = isDarkTheme,
                onSearchClick = { isSearchActive = true },
                onDeleteClick = { showDeleteAllDialog = true },
                onToggleTheme = onToggleTheme,
            )
        },
        floatingActionButton = { ShoppingListFab(onClick = { showAddDialog = true }) },
    ) { innerPadding ->
        when (val state = uiState) {
            is UiState.Empty -> ShoppingListEmptyState(
                isDarkTheme = isDarkTheme,
                modifier = Modifier.padding(innerPadding)
            )

            is UiState.Content -> ShoppingListContent(
                shoppingLists = state.shoppingLists,
                onShoppingListClick = onShoppingListClick,
                onIconClick = { listId -> iconSheetListId = listId },
                onDeleteConfirmed = { list -> viewModel.deleteList(list) },
                onRenameConfirmed = { list, name -> viewModel.renameList(list, name) },
                onCopyClick = { list -> viewModel.copyList(list) },
                contentPadding = innerPadding
            )
        }
    }

    if (showAddDialog) {
        AppDialogWindow(
            DialogWindow(
                title = stringResource(R.string.shopping_title_dialog),
                label = stringResource(R.string.shopping_edit_dialog),
                confirmText = stringResource(R.string.create_dialog),
                dismissText = stringResource(R.string.cancel_dialog),
                hint = stringResource(R.string.shopping_hint_dialog),
            ),
            onDismiss = { showAddDialog = false },
            onConfirm = { name ->
                viewModel.insertList(name)
                showAddDialog = false
            },
            iconResId = R.drawable.ic_dialog,
        )
    }

    if (showDeleteAllDialog) {
        AppConfirmDialog(
            ConfirmDialog(
                title = stringResource(R.string.shopping_list_delete_all_title),
                confirmText = stringResource(R.string.action_delete),
                dismissText = stringResource(R.string.cancel_dialog),
            ),
            onConfirm = {
                viewModel.deleteAllLists()
                showDeleteAllDialog = false
            },
            onDismiss = { showDeleteAllDialog = false },
            iconResId = R.drawable.ic_warning,
        )
    }

    iconSheetListId?.let { listId ->
        ShoppingListIconSheet(
            onIconSelected = { icon -> viewModel.changeListIcon(listId, icon) },
            onDismiss = { iconSheetListId = null },
        )
    }
}
