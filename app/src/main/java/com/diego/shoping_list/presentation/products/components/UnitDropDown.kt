package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.model.ProductUnit
import com.diego.shoping_list.presentation.common.AppDropdownMenu
import com.diego.shoping_list.presentation.common.AppDropdownMenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitDropdown(
    unit: ProductUnit?,
    onUnitChange: (ProductUnit) -> Unit,
    onExpandedChange: (Boolean) -> Unit = {},
    units: List<ProductUnit> = ProductUnit.entries,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val itemHeight = 48.dp
    val visibleHeight = itemHeight * 2.5f

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = it
            onExpandedChange(it)
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = stringResource(unit!!.labelRes()),
            onValueChange = {},
            readOnly = true,
            label = { Text(stringResource(R.string.unit_label)) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            singleLine = true,
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                .width(100.dp)
        )

        AppDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
                onExpandedChange(false) },
        ) {
            val containerColor = MaterialTheme.colorScheme.surfaceContainerHigh

            Box(modifier = Modifier.height(visibleHeight)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                ) {
                    units.forEach { option ->
                        AppDropdownMenuItem(
                            text = stringResource(option.labelRes()),
                            onClick = {
                                onUnitChange(option)
                                expanded = false
                                onExpandedChange(false)
                            }
                        )
                    }
                }

                if (scrollState.value > 0) {
                    FadeEdge(alignment = Alignment.TopCenter, color = containerColor)
                }
                if (scrollState.value < scrollState.maxValue) {
                    FadeEdge(alignment = Alignment.BottomCenter, color = containerColor)
                }
            }
        }
    }
}

@Composable
private fun BoxScope.FadeEdge(
    alignment: Alignment,
    color: Color,
    height: Dp = 12.dp,
) {
    val gradient = if (alignment == Alignment.TopCenter) {
        Brush.verticalGradient(listOf(color, Color.Transparent))
    } else {
        Brush.verticalGradient(listOf(Color.Transparent, color))
    }
    Box(
        modifier = Modifier
            .align(alignment)
            .fillMaxWidth()
            .height(height)
            .background(gradient)
    )
}


fun ProductUnit.labelRes(): Int = when (this) {
    ProductUnit.LITER -> R.string.unit_liter
    ProductUnit.MILLILITER -> R.string.unit_milliliter
    ProductUnit.PACK -> R.string.unit_pack
    ProductUnit.PACKET -> R.string.unit_packet
    ProductUnit.PIECE -> R.string.unit_piece
    ProductUnit.KILOGRAM -> R.string.unit_kilogram
    ProductUnit.GRAM -> R.string.unit_gram
}
