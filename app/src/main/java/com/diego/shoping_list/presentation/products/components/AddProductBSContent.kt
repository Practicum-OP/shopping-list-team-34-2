package com.diego.shoping_list.presentation.products.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun AddProductBottomSheetContent() {

    val focusManager = LocalFocusManager.current
    var nameInput by remember { mutableStateOf("") }
    var quantityInput by remember { mutableStateOf("1") }
    var unitInput by remember { mutableStateOf("шт") }

    var errorMsg by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        // ==== Имя продукта ====
        OutlinedTextField(
            value = nameInput,
            onValueChange = {
                nameInput = it
                errorMsg = null
            },
            label = { Text("Название продукта") },
            isError = errorMsg != null,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // ==== Количество + единица ====
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = quantityInput,
                onValueChange = { quantityInput = it.filter { c -> c.isDigit() } },
                label = { Text("Кол-во") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.width(120.dp)
            )
            Spacer(Modifier.width(8.dp))
            OutlinedTextField(
                value = unitInput,
                onValueChange = { unitInput = it },
                label = { Text("Ед.") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                modifier = Modifier.width(100.dp)
            )
        }

        // ==== Ошибка ====
        errorMsg?.let {
            Text(
                text = "⚠ $it",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}