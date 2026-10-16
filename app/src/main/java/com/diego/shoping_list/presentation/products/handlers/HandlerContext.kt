package com.diego.shoping_list.presentation.products.handlers

import com.diego.shoping_list.presentation.products.stateitems.ProductsEffect
import com.diego.shoping_list.presentation.products.stateitems.ProductsUiState
import kotlinx.coroutines.CoroutineScope

data class HandlerContext(
    val scope: CoroutineScope,
    val readState: () -> ProductsUiState,
    val updateState: ((ProductsUiState) -> ProductsUiState) -> Unit,
    val sendEffect: suspend (ProductsEffect) -> Unit
)