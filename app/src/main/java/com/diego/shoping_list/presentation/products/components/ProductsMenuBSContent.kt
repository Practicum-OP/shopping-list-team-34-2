package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.presentation.products.ProductsMenuEvent

@Composable
fun ProductsMenuBSContent(
    onEvent: (ProductsMenuEvent) -> Unit
) {
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
                    text = "Сортировка",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "По алфавиту",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Green
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_sort_button_24),
                contentDescription = ""
            )
        }
        Row(
            modifier = Modifier
                .height(56.dp)
                .padding(start = (16.dp), end = (16.dp))
                .clickable(onClick = { onEvent(ProductsMenuEvent.DeleteAll) }),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_delete_all_24),
                contentDescription = "DeleteAll"
            )
            Text(
                text = "Удалить все", modifier = Modifier.padding(start = (12.dp)),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Row(
            modifier = Modifier
                .height(56.dp)
                .padding(all = 16.dp)
                .clickable(onClick = { onEvent(ProductsMenuEvent.ClearChecked) }),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_clear_checked_24),
                contentDescription = "ClearChecked"
            )
            Text(
                text = "Очистить купленные", modifier = Modifier.padding(start = (12.dp)),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}