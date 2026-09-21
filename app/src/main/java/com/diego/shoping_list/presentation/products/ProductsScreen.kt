package com.diego.shoping_list.presentation.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ProductsScreen(
    listId: Long,
    onBackClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "ЭКРАН ПРОДУКТОВ", fontSize = 30.sp)
            Text(text = "Список покупок - $listId", fontSize = 20.sp)
            Text(text = "назад", modifier = Modifier.clickable(onClick = onBackClick))

        }
    }
}