package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.model.Product

@Composable
fun ProductItem(
    product: Product,
    onToggleChecked: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    dragHandleModifier: Modifier = Modifier,
    dragHandleEnable: Boolean = false
) {
    Column(
        modifier = Modifier
            .height(72.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable { onToggleChecked(!product.isChecked) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomCheckbox(
                checked = product.isChecked,
                onCheckedChange = onToggleChecked
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge,
                    textDecoration = if (product.isChecked) TextDecoration.LineThrough else null
                )
                Text(
                    text = "${product.quantity} ${product.unit}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (dragHandleEnable) {
                Icon(
                    painter = painterResource(R.drawable.ic_drag_handle_24),
                    contentDescription = "Drag to reorder",
                    modifier = dragHandleModifier
                )
            }
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant
        )
    }
}

@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val iconRes = if (checked) {

        R.drawable.ic_checkbox_on
    } else {
        R.drawable.ic_checkbox_off
    }

    IconButton(
        onClick = { onCheckedChange(!checked) },
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = if (checked) "Выбрано" else "Не выбрано",
            modifier = Modifier.size(24.dp),
            tint = Color.Unspecified
        )
    }
}
