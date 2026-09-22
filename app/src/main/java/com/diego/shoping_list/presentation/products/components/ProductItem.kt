package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.R
import com.diego.shoping_list.domain.model.Product

@Composable
fun ProductItem(product: Product) {
    var checked by remember { mutableStateOf(product.isChecked) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(72.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // ==== Чекбокс ====
        CustomCheckbox(
            checked = checked,
            onCheckedChange = { checked = it } /*{  checked ->
                    scope.launch {
                        productRepository.updateProduct(
                            product.copy(isChecked = checked)
                        )
                    }
            }*/
        )

        // ==== Левая часть: имя + кол-во ====
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${product.quantity} ${product.unit}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

//region ==== Кнопки ====
        /*IconButton(onClick = {*//*
                scope.launch {
                    productRepository.updateProduct(
                        product.copy(name = "${product.name}(edit)")
                    )
                }*//*
            }) {
                Text("edit")
            }

            IconButton(onClick = {*//*
                scope.launch {
                    productRepository.addProduct(
                        listId = product.listId,
                        name = "${product.name}(copy)",
                        quantity = product.quantity,
                        unit = product.unit
                    )
                }*//*
            }) {
                Text("copy")
            }

            IconButton(onClick = {*//*
                scope.launch {
                    productRepository.deleteProduct(product)
                }*//*
            }) {
                Text("del")
            }*/
//endregion
    }
}

@Preview
@Composable
private fun ProductItemPreview() {
    ProductItem(
        Product(
            id = 15,
            name = "Молоко",
            quantity = 2,
            unit = "л",
            isChecked = true
        )
    )
}

@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // Выбираем ресурс в зависимости от состояния
    val iconRes = if (checked) {

        R.drawable.ic_checkbox_on  // ваша иконка "выбрано"
    } else {
        R.drawable.ic_checkbox_off // ваша иконка "не выбрано"
    }

    IconButton(
        onClick = { onCheckedChange(!checked) },
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = if (checked) "Выбрано" else "Не выбрано",
            modifier = Modifier.size(24.dp), // при необходимости задайте размер
            tint = Color.Unspecified
        )
    }
}