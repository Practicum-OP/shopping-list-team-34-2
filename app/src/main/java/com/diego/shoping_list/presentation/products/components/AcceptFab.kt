package com.diego.shoping_list.presentation.products.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.diego.shoping_list.R

@Composable
fun FloatingOverlayButton(
    visible: Boolean,
    onClick: () -> Unit
) {
    val offsetY = with(LocalDensity.current) { (-250).dp.roundToPx() }

    if (!visible) return

    Popup(
        alignment = Alignment.BottomEnd,
        offset = IntOffset(-35, offsetY), // Уточнить отступы
        properties = PopupProperties(focusable = false)
    ) {
        FloatingActionButton(onClick = onClick) {
            Icon(
                painter = painterResource(R.drawable.ic_fab_apply),
                contentDescription = stringResource(R.string.action_add_list)
            )
        }
    }
}