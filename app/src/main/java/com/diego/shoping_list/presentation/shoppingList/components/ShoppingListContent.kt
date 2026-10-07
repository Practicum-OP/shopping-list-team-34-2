package com.diego.shoping_list.presentation.shoppingList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.ShoppingList
import com.diego.shoping_list.presentation.common.AppConfirmDialog
import com.diego.shoping_list.presentation.common.ConfirmDialog
import com.diego.shoping_list.presentation.common.DialogWindow
import com.diego.shoping_list.presentation.common.AppDialogWindow
import com.diego.shoping_list.ui.theme.Dimens

@Composable
@Suppress("LongParameterList")
fun ShoppingListContent(
    shoppingLists: List<ShoppingList>,
    onShoppingListClick: (Long) -> Unit,
    onIconClick: (Long) -> Unit,
    onDeleteConfirmed: (ShoppingList) -> Unit,
    onRenameConfirmed: (ShoppingList, String) -> Unit,
    onCopyClick: (ShoppingList) -> Unit,
    contentPadding: PaddingValues = PaddingValues(),
    modifier: Modifier = Modifier
) {
    var listToDelete by remember { mutableStateOf<ShoppingList?>(null) }
    var listToRename by remember { mutableStateOf<ShoppingList?>(null) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = Dimens.screenPadding,
            end = Dimens.screenPadding,
            top = contentPadding.calculateTopPadding() + Dimens.spacingSmall,
            bottom = contentPadding.calculateBottomPadding() + Dimens.listBottomSpace
        ),
        verticalArrangement = Arrangement.spacedBy(Dimens.spacingSmall)
    ) {
        items(shoppingLists, key = { it.id }) { shoppingList ->
            ShoppingListSwipeItem(
                onRenameClick = {
                    listToRename = shoppingList
                },
                onCopyClick = {
                    onCopyClick(shoppingList)
                },
                onDeleteClick = {
                    listToDelete = shoppingList
                },
            ) {
                ShoppingListCard(
                    shoppingList = shoppingList,
                    onClick = { onShoppingListClick(shoppingList.id) },
                    onIconClick = { onIconClick(shoppingList.id) }
                )
            }
        }
    }

    listToRename?.let { selectedList ->
        AppDialogWindow(
            DialogWindow(
                title = stringResource(R.string.action_rename),
                label = stringResource(R.string.shopping_edit_dialog),
                confirmText = stringResource(R.string.action_rename),
                dismissText = stringResource(R.string.cancel_dialog),
                initialValue = selectedList.nameList,
            ),
            onConfirm = { newName ->
                onRenameConfirmed(selectedList, newName)
                listToRename = null
            },
            onDismiss = {
                listToRename = null
            },
            iconResId = R.drawable.ic_rename
        )
    }

    listToDelete?.let { selectedList ->
        AppConfirmDialog(
            ConfirmDialog(
                title = stringResource(R.string.delete_list, selectedList.nameList),
                confirmText = stringResource(R.string.action_delete),
                dismissText = stringResource(R.string.cancel_dialog),
            ),
            onConfirm = {
                onDeleteConfirmed(selectedList)
                listToDelete = null
            },
            onDismiss = {
                listToDelete = null
            },
            iconResId = R.drawable.ic_warning
        )
    }
}
