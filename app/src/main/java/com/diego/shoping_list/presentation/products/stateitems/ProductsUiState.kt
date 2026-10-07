package com.diego.shoping_list.presentation.products.stateitems

import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.domain.model.Product

data class ProductsUiState(
    val products: List<Product> = emptyList(),
    val isAddSheetVisible: Boolean = false,
    val isMenuSheetVisible: Boolean = false,
    val isDeleteAllDialogVisible: Boolean = false,
    val isClearCheckedDialogVisible: Boolean = false,
    val addForm: AddProductFormState = AddProductFormState(),
    val sortMode: SortMode = SortMode.ALPHABETICAL,
    val isDragging: Boolean = false,
) {
    val isListEmpty: Boolean get() = products.isEmpty()
    val hasCheckedItems: Boolean get() = products.any { it.isChecked }
    val showEmptyPlaceholder: Boolean get() = products.isEmpty() && !isAddSheetVisible
    val canClearChecked: Boolean get() = hasCheckedItems
    val canDeleteAll: Boolean get() = !isListEmpty
    val isManualSortMode: Boolean get() = sortMode == SortMode.MANUAL
}