package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.SortMode
import com.diego.shoping_list.presentation.products.stateitems.ProductsMenuEvent

@Composable
fun ProductsMenuBSContent(
    sortMode: SortMode,
    onEvent: (ProductsMenuEvent) -> Unit
) {
    var showPopup by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .padding(start = (16.dp), end = (16.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_sort_icon_24),
                contentDescription = "Sorting"
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = (12.dp))
            ) {
                Text(
                    text = stringResource(R.string.products_menu_sorting),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = when (sortMode) {
                        SortMode.ALPHABETICAL -> {
                            "По алфавиту"
                        }

                        SortMode.MANUAL -> {
                            "Пользовательская"
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (showPopup) Color.Gray else Color.Green
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_sort_button_24),
                contentDescription = "",
                modifier = Modifier.clickable(onClick = { showPopup = true })
            )
            Box {
                if (showPopup) {
                    DropdownMenu(
                        expanded = true,
                        onDismissRequest = { showPopup = false },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        SortModeMenuItem(
                            iconRes = R.drawable.ic_sort_by_alphabet_24,
                            textRes = R.string.products_menu_sort_by_alphabet,
                            selected = sortMode == SortMode.ALPHABETICAL,
                            onClick = {
                                onEvent(ProductsMenuEvent.SortByAlphabet)
                                showPopup = false
                            }
                        )
                        SortModeMenuItem(
                            iconRes = R.drawable.ic_sort_by_user_24,
                            textRes = R.string.products_menu_sort_by_user,
                            selected = sortMode == SortMode.MANUAL,
                            onClick = {
                                onEvent(ProductsMenuEvent.SortByUser)
                                showPopup = false
                            }
                        )

                    }
                }
            }
        }
        MenuRow(
            iconRes = R.drawable.ic_delete_all_24,
            textRes = R.string.products_menu_delete_all,
            onClick = { onEvent(ProductsMenuEvent.DeleteAll) }
        )
        MenuRow(
            iconRes = R.drawable.ic_clear_checked_24,
            textRes = R.string.products_menu_clear_checked,
            onClick = { onEvent(ProductsMenuEvent.ClearChecked) }
        )
    }
}

@Composable
private fun SortModeMenuItem(
    iconRes: Int,
    textRes: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        text = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = null
                )
                Text(
                    text = stringResource(textRes),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 12.dp)
                )
                IconButton(
                    onClick = { onClick() }
                ) {
                    val iconButtonRes = if (selected) {
                        R.drawable.ic_checkbox_on
                    } else {
                        R.drawable.ic_checkbox_off
                    }
                    Icon(
                        painter = painterResource(id = iconButtonRes),
                        contentDescription = if (selected) "Выбрано" else "Не выбрано",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        },
        onClick = onClick
    )
}

@Composable
private fun MenuRow(
    iconRes: Int,
    textRes: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null
        )
        Text(
            text = stringResource(textRes),
            modifier = Modifier.padding(start = 12.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}