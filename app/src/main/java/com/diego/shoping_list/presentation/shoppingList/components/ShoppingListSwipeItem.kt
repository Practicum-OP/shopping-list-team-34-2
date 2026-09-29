package com.diego.shoping_list.presentation.shoppingList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.diego.shoping_list.R
import com.diego.shoping_list.ui.theme.Dimens
import kotlinx.coroutines.launch

@Composable
fun ShoppingListSwipeItem(
    onRenameClick: () -> Unit,
    onCopyClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val swipeState = rememberSwipeToDismissBoxState()
    val scope = rememberCoroutineScope()

    fun closeMenu() {
        scope.launch { swipeState.reset() }
    }

    SwipeToDismissBox(
        state = swipeState,
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimens.spacingSmall, Alignment.End),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize(),
            ) {
                ShoppingListSwipeButton(
                    iconResId = R.drawable.ic_rename,
                    contentDescription = stringResource(R.string.action_rename),
                    onClick = {
                        onRenameClick()
                        closeMenu()
                    },
                )
                ShoppingListSwipeButton(
                    iconResId = R.drawable.ic_copy,
                    contentDescription = stringResource(R.string.action_copy),
                    onClick = {
                        onCopyClick()
                        closeMenu()
                    },
                )
                ShoppingListSwipeButton(
                    iconResId = R.drawable.ic_delete,
                    contentDescription = stringResource(R.string.action_delete),
                    onClick = {
                        onDeleteClick()
                        closeMenu()
                    },
                )
            }
        },
        modifier = modifier,
    ) {
        content()
    }
}
