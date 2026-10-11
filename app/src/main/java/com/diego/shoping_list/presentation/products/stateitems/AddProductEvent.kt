package com.diego.shoping_list.presentation.products.stateitems

import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.domain.model.ProductUnit

sealed interface AddProductEvent {
    data class NameChange(val value: String) : AddProductEvent
    data class QuantityChange(val value: String) : AddProductEvent
    data class UnitChange(val value: ProductUnit) : AddProductEvent
    data class SuggestionSelected(val suggestion: ProductSuggestion) : AddProductEvent
    data class EditProduct(val productId: Long) : AddProductEvent
    data object Increment : AddProductEvent
    data object Decrement : AddProductEvent
    data object Submit : AddProductEvent
    data object Reset : AddProductEvent
}