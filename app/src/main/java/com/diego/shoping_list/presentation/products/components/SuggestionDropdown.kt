package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.diego.shoping_list.domain.model.ProductSuggestion
import com.diego.shoping_list.presentation.common.AppDropdownMenu
import com.diego.shoping_list.presentation.common.AppDropdownMenuItem

@Composable
fun SuggestionDropdown(
    expanded: Boolean,
    suggestions: List<ProductSuggestion>,
    actions: SuggestionDropdownActions,
    modifier: Modifier = Modifier,
    maxHeight: Dp = 256.dp,
) {
    AppDropdownMenu(
        expanded = expanded,
        onDismissRequest = actions.onDismiss,
        modifier = modifier,
        properties = PopupProperties(focusable = false),
    ) {
        Column(
            modifier = Modifier
                .heightIn(max = maxHeight)
                .verticalScroll(rememberScrollState())
        ) {
            suggestions.forEach { suggestion ->
                AppDropdownMenuItem(
                    text = suggestion.name,
                    onClick = { actions.onSuggestionClick(suggestion) }
                )
            }
        }
    }
}

data class SuggestionDropdownActions(
    val onSuggestionClick: (ProductSuggestion) -> Unit,
    val onDismiss: () -> Unit
)