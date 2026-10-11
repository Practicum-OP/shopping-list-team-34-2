package com.diego.shoping_list.presentation.common

data class SwipeState(
    val itemId: String,
    val openItemId: String?,
    val onOpenItemChange: (String?) -> Unit
) {
    val isOpen: Boolean get() = openItemId == itemId

    fun close() {
        if (isOpen) onOpenItemChange(null)
    }
}