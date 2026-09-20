package com.diego.shoping_list.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.diego.shoping_list.data.database.entities.ShoppingListEntity
import com.diego.shoping_list.data.database.repository.ShoppingListRepository
import com.diego.shoping_list.domain.IconPicker
import com.diego.shoping_list.domain.ListIcon
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun TestDbScreen(
    modifier: Modifier = Modifier,
    repository: ShoppingListRepository = koinInject()
) {
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    var lists by remember { mutableStateOf<List<ShoppingListEntity>>(emptyList()) }
    var nameInput by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf<String?>(null) }
    var selectedIcon by remember { mutableStateOf(ListIcon.default) }

    LaunchedEffect(Unit) {
        repository.observeAll().collectLatest { lists = it }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = nameInput,
            onValueChange = {
                nameInput = it
                errorMsg = null                 // ← сбрасываем ошибку при вводе
            },
            label = { Text("Название списка") },
            isError = errorMsg != null,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // === Ошибка под полем ===
        errorMsg?.let {
            Text(
                text = "⚠ $it",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp, start = 4.dp)
            )
        }

        Text("Выберите иконку:")
        Spacer(Modifier.height(8.dp))

        // ← IconPicker внутри Box с фиксированной высотой
        IconPicker(
            selected = selectedIcon,
            onSelect = { selectedIcon = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                focusManager.clearFocus()
                scope.launch {
                    repository.addList(nameInput, selectedIcon.key)
                        .onSuccess { errorMsg = null }
                        .onFailure { errorMsg = it.message ?: "Ошибка" }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Добавить список (icon = ${selectedIcon.key})")
        }

        errorMsg?.let {
            Text("⚠ $it", modifier = Modifier.padding(vertical = 8.dp))
        }

        Text("Всего списков: ${lists.size}", modifier = Modifier.padding(vertical = 8.dp))

        // ← LazyColumn занимает остаток высоты
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(lists, key = { it.id }) { list ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val icon = ListIcon.fromKey(list.iconKey)
                        Image(
                            painter = painterResource(icon.resId),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text("id = ${list.id}")
                            Text("name = ${list.nameList}")
                            Text("icon = ${list.iconKey}")
                        }
                    }
                }
            }
        }
    }
}