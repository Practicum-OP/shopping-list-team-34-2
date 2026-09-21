package com.diego.shoping_list.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.data.database.entities.ProductInListEntity
import com.diego.shoping_list.data.database.entities.ShoppingListEntity
import com.diego.shoping_list.data.database.repository.ProductInListRepository
import com.diego.shoping_list.data.database.repository.ShoppingListRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun TestDbProductScreen(
    modifier: Modifier = Modifier,
    productRepository: ProductInListRepository = koinInject(),
    listRepository: ShoppingListRepository = koinInject()
) {
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    // ==== Состояние экрана ====
    var lists by remember { mutableStateOf<List<ShoppingListEntity>>(emptyList()) }
    var selectedList by remember { mutableStateOf<ShoppingListEntity?>(null) }

    var products by remember { mutableStateOf<List<ProductInListEntity>>(emptyList()) }

    var nameInput by remember { mutableStateOf("") }
    var quantityInput by remember { mutableStateOf("1") }
    var unitInput by remember { mutableStateOf("шт") }

    var errorMsg by remember { mutableStateOf<String?>(null) }

    // ==== Загружаем все списки ====
    LaunchedEffect(Unit) {
        listRepository.searchByName("").collectLatest { all ->
            lists = all
            // Если ничего не выбрано — выбираем первый список
            if (selectedList == null && all.isNotEmpty()) {
                selectedList = all.first()
            }
        }
    }

    // ==== Подписка на продукты выбранного списка ====
    LaunchedEffect(selectedList?.id) {
        val id = selectedList?.id ?: return@LaunchedEffect
        productRepository.observeByList(id).collectLatest { products = it }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // ==== Выбор списка (dropdown) ====
        Text("Список:")
        Spacer(Modifier.height(4.dp))
        ListDropdown(
            lists = lists,
            selected = selectedList,
            onSelect = { selectedList = it }
        )

        Spacer(Modifier.height(16.dp))

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

        Spacer(Modifier.height(16.dp))

        // ==== Кнопка Добавить ====
        Button(
            onClick = {
                val list = selectedList
                if (list == null) {
                    errorMsg = "Сначала создайте или выберите список"
                    return@Button
                }

                val quantity = quantityInput.toIntOrNull() ?: 0
                focusManager.clearFocus()

                scope.launch {
                    productRepository.addProduct(
                        listId = list.id,
                        name = nameInput,
                        quantity = quantity,
                        unit = unitInput
                    )
                        .onSuccess {
                            nameInput = ""
                            quantityInput = "1"
                            unitInput = "шт"
                            errorMsg = null
                        }
                        .onFailure { errorMsg = it.message ?: "Ошибка" }
                }
            },
            enabled = nameInput.isNotBlank() && selectedList != null,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Добавить продукт")
        }

        Spacer(Modifier.height(16.dp))

        Text("Продуктов: ${products.size}")

        Spacer(Modifier.height(8.dp))

        // ==== Список продуктов ====
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(products, key = { it.id }) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // ==== Чекбокс ====
                        Checkbox(
                            checked = product.isChecked,
                            onCheckedChange = { checked ->
                                scope.launch {
                                    productRepository.updateProduct(
                                        product.copy(isChecked = checked)
                                    )
                                }
                            }
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

                        // ==== Кнопки ====
                        IconButton(onClick = {
                            scope.launch {
                                productRepository.updateProduct(
                                    product.copy(name = "${product.name}(edit)")
                                )
                            }
                        }) {
                            Text("edit")
                        }

                        IconButton(onClick = {
                            scope.launch {
                                productRepository.addProduct(
                                    listId = product.listId,
                                    name = "${product.name}(copy)",
                                    quantity = product.quantity,
                                    unit = product.unit
                                )
                            }
                        }) {
                            Text("copy")
                        }

                        IconButton(onClick = {
                            scope.launch {
                                productRepository.deleteProduct(product)
                            }
                        }) {
                            Text("del")
                        }
                    }
                }
            }
        }
    }
}

// ==== Dropdown для выбора списка ====
@Composable
private fun ListDropdown(
    lists: List<ShoppingListEntity>,
    selected: ShoppingListEntity?,
    onSelect: (ShoppingListEntity) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(selected?.nameList ?: "— выберите список —")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            lists.forEach { list ->
                DropdownMenuItem(
                    text = { Text(list.nameList) },
                    onClick = {
                        onSelect(list)
                        expanded = false
                    }
                )
            }
        }
    }
}