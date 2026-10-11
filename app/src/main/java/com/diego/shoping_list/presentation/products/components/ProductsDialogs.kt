package com.diego.shoping_list.presentation.products.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.diego.shoping_list.R
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import com.diego.shoping_list.presentation.products.stateitems.ProductsMenuEvent
import com.diego.shoping_list.presentation.products.stateitems.ProductsUiState

@Composable
fun ProductsDialogs(
    state: ProductsUiState,
    onIntent: (ProductsIntent) -> Unit
) {
    val productToDelete = state.productToDelete

    if (state.isDeleteProductDialogVisible && productToDelete != null) {
        ConfirmDialog(
            title = stringResource(R.string.products_dialog_delete_product, productToDelete.name),
            onConfirm = { onIntent(ProductsIntent.ConfirmDeleteProduct) },
            onDismiss = { onIntent(ProductsIntent.DismissDeleteProduct) }
        )
    }

    if (state.isDeleteAllDialogVisible) {
        ConfirmDialog(
            title = stringResource(R.string.products_dialog_delete_all),
            onConfirm = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.ConfirmDeleteAll)) },
            onDismiss = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.DismissDeleteAllDialog)) }
        )
    }

    if (state.isClearCheckedDialogVisible) {
        ConfirmDialog(
            title = stringResource(R.string.products_dialog_clear_checked),
            onConfirm = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.ConfirmClearChecked)) },
            onDismiss = { onIntent(ProductsIntent.Menu(ProductsMenuEvent.DismissClearCheckedDialog)) }
        )
    }
}