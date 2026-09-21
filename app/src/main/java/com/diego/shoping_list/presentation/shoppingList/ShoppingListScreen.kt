package com.diego.shoping_list.presentation.shoppingList

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
fun ShoppingListScreen(
    onShoppingListClick: (Long) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "ЭКРАН СПИСКА ПОКУПОК", fontSize = 30.sp)
            Text(text = "к списку продуктов", modifier = Modifier.clickable {
                val selectedListId = 123L  // ← заменить на реальный ID
                onShoppingListClick(selectedListId)
            })
        }
    }
}