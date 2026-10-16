package com.diego.shoping_list.presentation.products.components

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.AddProductFormState
import com.diego.shoping_list.presentation.products.stateitems.ProductsIntent
import com.diego.shoping_list.presentation.products.stateitems.ProductsMenuEvent
import com.diego.shoping_list.presentation.products.stateitems.ProductsUiState
import kotlinx.coroutines.flow.Flow

@Composable
fun ProductsSheets(
    state: ProductsUiState,
    onIntent: (ProductsIntent) -> Unit,
    onQuerySuggestions: (String) -> Flow<List<ProductSuggestion>>
) {
    if (state.isAddSheetVisible) {
        AddProductBottomSheet(
            state = state.addForm,
            onEvent = { event -> onIntent(ProductsIntent.AddProduct(event)) },
            onDismiss = { onIntent(ProductsIntent.DismissAddProduct) },
            onQuerySuggestions = onQuerySuggestions
        )
    }

    if (state.isMenuSheetVisible) {
        ProductsMenuBottomSheet(
            sortMode = state.sortMode,
            canDeleteAll = state.canDeleteAll,
            canClearChecked = state.canClearChecked,
            onEvent = { event -> onIntent(ProductsIntent.Menu(event)) },
            onDismiss = { onIntent(ProductsIntent.DismissProductMenu) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddProductBottomSheet(
    state: AddProductFormState,
    onEvent: (AddProductEvent) -> Unit,
    onDismiss: () -> Unit,
    onQuerySuggestions: (String) -> Flow<List<ProductSuggestion>>
) {
    val sheetState = rememberModalBottomSheetState(
    )
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        AddProductBottomSheetContent(
            state = state,
            onEvent = onEvent,
            onQuerySuggestions = onQuerySuggestions,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductsMenuBottomSheet(
    sortMode: SortMode,
    canDeleteAll: Boolean,
    canClearChecked: Boolean,
    onEvent: (ProductsMenuEvent) -> Unit,
    onDismiss: () -> Unit
) {
    val menuSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = menuSheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        ProductsMenuBSContent(
            sortMode = sortMode,
            canDeleteAll = canDeleteAll,
            canClearChecked = canClearChecked,
            onEvent = onEvent
        )
    }
}