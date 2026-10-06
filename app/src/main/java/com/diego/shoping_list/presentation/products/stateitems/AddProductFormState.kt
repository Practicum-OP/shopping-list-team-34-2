package com.diego.shoping_list.presentation.products.stateitems

import com.diego.shoping_list.domain.model.Product

data class AddProductFormState(
    val editingProduct: Product? = null,
    val name: String = "",
    val quantity: String = "",
    val unit: String = "шт",
    val nameError: String? = null,
    val quantityError: String? = null,
    val isSubmitting: Boolean = false
) {
    val canSubmit: Boolean
        get() = name.isNotBlank()
                && quantity.toIntOrNull()?.let { it in 1..999 } == true
                && !isSubmitting
}