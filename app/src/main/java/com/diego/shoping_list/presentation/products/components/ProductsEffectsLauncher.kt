package com.diego.shoping_list.presentation.products.components

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.diego.shoping_list.R
import com.diego.shoping_list.presentation.products.stateitems.ProductsEffect
import com.diego.shoping_list.presentation.products.stateitems.ProductsError
import com.diego.shoping_list.presentation.products.stateitems.ProductsToast
import kotlinx.coroutines.flow.Flow

@Composable
fun ProductsEffectsLauncher(
    effects: Flow<ProductsEffect>,
    snackbarHostState: SnackbarHostState,
    context: android.content.Context
) {
    LaunchedEffect(Unit) {
        effects.collect { effect ->
            when (effect) {
                is ProductsEffect.ShowError ->
                    snackbarHostState.showSnackbar(context.getString(effect.error.toStringRes()))

                is ProductsEffect.ShowToast ->
                    Toast.makeText(
                        context,
                        context.getString(effect.toast.toStringRes()),
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }
}

@StringRes
private fun ProductsError.toStringRes(): Int = when (this) {
    ProductsError.SaveFailed -> R.string.error_save_product
    ProductsError.DeleteFailed -> R.string.error_delete_product
    ProductsError.SaveOrderFailed -> R.string.error_save_order
    ProductsError.Unknown -> R.string.error_unknown
}

@StringRes
private fun ProductsToast.toStringRes(): Int = when (this) {
    ProductsToast.ProductSaved -> R.string.toast_product_saved
    ProductsToast.ProductDeleted -> R.string.toast_product_deleted
}