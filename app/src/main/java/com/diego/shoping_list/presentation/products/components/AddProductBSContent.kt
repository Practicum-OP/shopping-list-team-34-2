package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.presentation.products.stateitems.AddProductEvent
import com.diego.shoping_list.presentation.products.stateitems.AddProductFormState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration.Companion.milliseconds

private sealed interface Overlay {
    data object UnitMenu : Overlay
    data object Suggestions : Overlay
}

@Composable
fun AddProductBottomSheetContent(
    state: AddProductFormState,
    onEvent: (AddProductEvent) -> Unit,
    onQuerySuggestions: (String) -> Flow<List<ProductSuggestion>>
) {

    var suggestions by remember(state.editingProduct?.id) {
        mutableStateOf<List<ProductSuggestion>>(emptyList())
    }
    var showSuggestions by remember(state.editingProduct?.id) { mutableStateOf(false) }
    var lastSelected by remember(state.editingProduct?.id) { mutableStateOf<String?>(null) }

    val minQuantity = 1
    val maxQuantity = 999
    val quantityValue = state.quantity.toIntOrNull()
    val decrementEnabled = quantityValue != null && quantityValue > minQuantity
    val incrementEnabled = (quantityValue ?: 0) < maxQuantity


    val visibleSuggestions = suggestions
    val reservedHeight = remember(visibleSuggestions.size) {
        (SUGGESTION_ITEM_HEIGHT * visibleSuggestions.size + MENU_VERTICAL_MARGIN * 2)
            .coerceAtMost(MAX_RESERVED_HEIGHT)
    }

    var openOverlay by remember(state.editingProduct?.id) {
        mutableStateOf<Overlay?>(null)
    }

    LaunchedEffect(showSuggestions, suggestions.size, openOverlay) {
        if (showSuggestions && suggestions.isNotEmpty() && openOverlay == null) {
            openOverlay = Overlay.Suggestions
        } else if (!showSuggestions && openOverlay == Overlay.Suggestions) {
            openOverlay = null
        }
    }

    val overlayLift = when (openOverlay) {
        Overlay.UnitMenu -> UNIT_RESERVED_HEIGHT
        Overlay.Suggestions -> reservedHeight
        null -> 0.dp
    }


    LaunchedEffect(state.name, state.editingProduct?.id) {
        val q = state.name
        if (shouldSkipSearch(q, state.editingProduct, lastSelected)) {
            suggestions = emptyList()
            showSuggestions = false
            return@LaunchedEffect
        }

        delay(200.milliseconds)
        onQuerySuggestions(q).collect { list ->
            suggestions = list
            showSuggestions = list.isNotEmpty()
        }
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.name,
                    onValueChange = { onEvent(AddProductEvent.NameChange(it)) },
                    label = { Text(stringResource(R.string.name_label)) },
                    isError = state.nameError != null,
                    supportingText = state.nameError?.let { { Text(it) } },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { focusState ->
                            if (!focusState.isFocused && showSuggestions) {
                                showSuggestions = false
                            }
                        }
                )

                SuggestionDropdown(
                    expanded = showSuggestions,
                    suggestions = suggestions,
                    onSuggestionClick = { suggestion ->
                        lastSelected = suggestion.name
                        onEvent(AddProductEvent.SuggestionSelected(suggestion))
                        suggestions = emptyList()
                        showSuggestions = false
                    },
                    onDismiss = { showSuggestions = false },
                    modifier = Modifier.fillMaxWidth(0.9f),
                    maxHeight = MAX_RESERVED_HEIGHT - MENU_VERTICAL_MARGIN * 2,
                )

            }

            Spacer(Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                OutlinedTextField(
                    value = state.quantity,
                    onValueChange = { onEvent(AddProductEvent.QuantityChange(it)) },
                    label = { Text(stringResource(R.string.quantity_label)) },
                    isError = state.quantityError != null,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.width(120.dp)
                )

                Spacer(Modifier.width(8.dp))

                UnitDropdown(
                    unit = state.unit,
                    onUnitChange = { onEvent(AddProductEvent.UnitChange(it)) },
                    onExpandedChange = { open ->
                        openOverlay = if (open) Overlay.UnitMenu else null
                        if (open) showSuggestions = false
                    },
                    modifier = Modifier.width(100.dp)
                )

                IconButton(
                    onClick = { onEvent(AddProductEvent.Decrement) },
                    enabled = decrementEnabled
                ) {
                    Icon(
                        painter = painterResource(
                            if (decrementEnabled) R.drawable.ic_decrease_on
                            else R.drawable.ic_decrease_off
                        ),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }

                IconButton(
                    onClick = { onEvent(AddProductEvent.Increment) },
                    enabled = incrementEnabled
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_increase),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }

            if (openOverlay != null) {
                Spacer(Modifier.height(overlayLift))
            }

            FloatingOverlayButton(
                visible = true,
                enabled = state.canSubmit,
                onClick = {
                    onEvent(AddProductEvent.Submit)
                },
                extraOffset = overlayLift
            )
        }
    }
}

private fun shouldSkipSearch(
    query: String,
    editingProduct: Product?,
    lastSelected: String?
): Boolean =
    query.isBlank() ||
            query == editingProduct?.name ||
            query == lastSelected

private val SUGGESTION_ITEM_HEIGHT = 48.dp
private val MENU_VERTICAL_MARGIN = 8.dp
private val MAX_RESERVED_HEIGHT = 256.dp
private val UNIT_RESERVED_HEIGHT = 196.dp