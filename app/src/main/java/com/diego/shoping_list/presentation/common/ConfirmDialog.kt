package com.diego.shoping_list.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

data class ConfirmDialog (
    val title: String,
    val confirmText: String,
    val dismissText: String,
)

@Composable
fun AppConfirmDialog(
    confirmDialog: ConfirmDialog,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconResId: Int? = null,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier,
        icon = iconResId?.let {
            {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null,
                )
            }
        },
        title = { Text(text = confirmDialog.title) },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = confirmDialog.confirmText)
            }
        },
        dismissButton = {
            FilledTonalButton(onClick = onDismiss) {
                Text(text = confirmDialog.dismissText)
            }
        },
        iconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    )
}
