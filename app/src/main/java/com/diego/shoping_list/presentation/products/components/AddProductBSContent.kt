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
import androidx.compose.runtime.Stable
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.model.Product
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.domain.model.ProductUnit
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

    val sugg = rememberSuggestionState(state.editingProduct?.id)

    SuggestionSearchEffect(
        query = state.name,
        editingProduct = state.editingProduct,
        onQuerySuggestions = onQuerySuggestions,
        state = sugg
    )

    val quantityValue = state.quantity.toIntOrNull()
    val decrementEnabled = quantityValue != null && quantityValue > MIN_QUANTITY
    val incrementEnabled = (quantityValue ?: 0) < MAX_QUANTITY

    val (overlayController, overlayLift) =
        rememberOverlayController(sugg.showSuggestions, sugg.suggestions.size)

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                ProductNameField(
                    value = state.name,
                    error = state.nameError,
                    onValueChange = { onEvent(AddProductEvent.NameChange(it)) },
                    onFocusLost = { sugg.showSuggestions = false }
                )

                SuggestionDropdown(
                    expanded = sugg.showSuggestions,
                    suggestions = sugg.suggestions,
                    actions = SuggestionDropdownActions(
                        onSuggestionClick = { suggestion ->
                            sugg.lastSelected = suggestion.name
                            onEvent(AddProductEvent.SuggestionSelected(suggestion))
                            sugg.suggestions = emptyList()
                            sugg.showSuggestions = false
                        },
                        onDismiss = { sugg.showSuggestions = false }
                    ),
                    modifier = Modifier.fillMaxWidth(0.9f),
                    maxHeight = MAX_RESERVED_HEIGHT - MENU_VERTICAL_MARGIN * 2
                )
            }

            Spacer(Modifier.height(8.dp))

            QuantityAndUnitRow(
                state = QuantityUnitState(
                    quantity = state.quantity,
                    quantityError = state.quantityError,
                    unit = state.unit,
                    decrementEnabled = decrementEnabled,
                    incrementEnabled = incrementEnabled
                ),
                actions = QuantityUnitActions(
                    onQuantityChange = { onEvent(AddProductEvent.QuantityChange(it)) },
                    onUnitChange = { onEvent(AddProductEvent.UnitChange(it)) },
                    onUnitExpandedChange = { open ->
                        overlayController.openOverlay = if (open) Overlay.UnitMenu else null
                        if (open) sugg.showSuggestions = false
                    },
                    onDecrement = { onEvent(AddProductEvent.Decrement) },
                    onIncrement = { onEvent(AddProductEvent.Increment) }
                ))

            if (overlayController.openOverlay != null) {
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

@Stable
private class SuggestionState(
    initial: List<ProductSuggestion> = emptyList(),
) {
    var suggestions by mutableStateOf(initial)
    var showSuggestions by mutableStateOf(false)
    var lastSelected by mutableStateOf<String?>(null)
}

@Composable
private fun rememberSuggestionState(editingProductId: Long?): SuggestionState =
    remember(editingProductId) { SuggestionState() }

@Composable
private fun SuggestionSearchEffect(
    query: String,
    editingProduct: Product?,
    onQuerySuggestions: (String) -> Flow<List<ProductSuggestion>>,
    state: SuggestionState
) {
    LaunchedEffect(query, editingProduct?.id) {
        if (shouldSkipSearch(query, editingProduct, state.lastSelected)) {
            state.suggestions = emptyList()
            state.showSuggestions = false
            return@LaunchedEffect
        }

        delay(200.milliseconds)
        onQuerySuggestions(query).collect { list ->
            state.suggestions = list
            state.showSuggestions = list.isNotEmpty()
        }
    }
}

private fun resolveOverlay(
    showSuggestions: Boolean,
    suggestionCount: Int,
    current: Overlay?
): Overlay? = when {
    showSuggestions && suggestionCount > 0 && current == null -> Overlay.Suggestions
    !showSuggestions && current == Overlay.Suggestions -> null
    else -> current
}

private class OverlayController {
    var openOverlay by mutableStateOf<Overlay?>(null)
}

@Composable
private fun rememberOverlayController(
    showSuggestions: Boolean,
    suggestionCount: Int
): Pair<OverlayController, Dp> {
    val controller = remember { OverlayController() }
    val reservedHeight = remember(suggestionCount) {
        (SUGGESTION_ITEM_HEIGHT * suggestionCount + MENU_VERTICAL_MARGIN * 2)
            .coerceAtMost(MAX_RESERVED_HEIGHT)
    }

    LaunchedEffect(showSuggestions, suggestionCount, controller.openOverlay) {
        controller.openOverlay =
            resolveOverlay(showSuggestions, suggestionCount, controller.openOverlay)
    }

    val lift = when (controller.openOverlay) {
        Overlay.UnitMenu -> UNIT_RESERVED_HEIGHT
        Overlay.Suggestions -> reservedHeight
        null -> 0.dp
    }
    return controller to lift
}

@Composable
private fun ProductNameField(
    value: String,
    error: String?,
    onValueChange: (String) -> Unit,
    onFocusLost: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.name_label)) },
        isError = error != null,
        supportingText = error?.let { { Text(it) } },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged { focus -> if (!focus.isFocused) onFocusLost() }
    )
}

@Composable
private fun QuantityAndUnitRow(
    state: QuantityUnitState,
    actions: QuantityUnitActions
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = state.quantity,
            onValueChange = actions.onQuantityChange,
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
            onUnitChange = actions.onUnitChange,
            onExpandedChange = actions.onUnitExpandedChange,
            modifier = Modifier.width(100.dp)
        )

        QuantityStepperButton(
            enabled = state.decrementEnabled,
            iconRes = if (state.decrementEnabled) R.drawable.ic_decrease_on else R.drawable.ic_decrease_off,
            onClick = actions.onDecrement
        )
        QuantityStepperButton(
            enabled = state.incrementEnabled,
            iconRes = R.drawable.ic_increase,
            onClick = actions.onIncrement
        )
    }
}

@Composable
private fun QuantityStepperButton(
    enabled: Boolean,
    iconRes: Int,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick, enabled = enabled) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Stable
private data class QuantityUnitState(
    val quantity: String,
    val quantityError: String?,
    val unit: ProductUnit?,
    val decrementEnabled: Boolean,
    val incrementEnabled: Boolean
)

@Stable
private data class QuantityUnitActions(
    val onQuantityChange: (String) -> Unit,
    val onUnitChange: (ProductUnit) -> Unit,
    val onUnitExpandedChange: (Boolean) -> Unit,
    val onDecrement: () -> Unit,
    val onIncrement: () -> Unit
)

private const val MIN_QUANTITY = 1
private const val MAX_QUANTITY = 999

private val SUGGESTION_ITEM_HEIGHT = 48.dp
private val MENU_VERTICAL_MARGIN = 8.dp
private val MAX_RESERVED_HEIGHT = 256.dp
private val UNIT_RESERVED_HEIGHT = 196.dp