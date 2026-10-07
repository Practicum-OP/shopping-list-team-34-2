package com.diego.shoping_list.presentation.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun PasswordEditor(
    viewModel: AuthViewModel,
    focusRequester: FocusRequester,
    focusManager: FocusManager,
    state: AuthUiState
) {
    var passwordFirst by remember { mutableStateOf("") }
    var passwordSecond by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf<String?>(null) }

    val keyboardController = LocalSoftwareKeyboardController.current

    // Проверка совпадения паролей при любом изменении
    fun validatePasswords() {
        passwordError = when {
            passwordSecond.isEmpty() -> null
            passwordSecond != passwordFirst -> "Пароли не совпадают"
            passwordFirst.length < 6 -> "Пароль должен быть не короче 7 символов"
            else -> null
        }
    }

    OutlinedTextField(
        value = passwordFirst,
        onValueChange = { value ->
            passwordFirst = value
            validatePasswords()
        },
        label = { Text("Password") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        isError = passwordError != null,
        supportingText = passwordError?.let { { Text(it) } },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFA370EE),
            unfocusedBorderColor = Color.LightGray,
            focusedLabelColor = Color(0xFFA370EE),
            cursorColor = Color(0xFFA370EE),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
        ),
    )

    // Повтор пароля
    OutlinedTextField(
        value = passwordSecond,
        onValueChange = { value ->
            passwordSecond = value
            validatePasswords()
        },
        label = { Text("Repeat password") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                if (passwordError == null && passwordFirst.isNotBlank()) {
                    viewModel.register(state.email, passwordFirst)
                }
            }
        ),
        isError = passwordError != null,
        supportingText = passwordError?.let { { Text(it) } },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFA370EE),
            unfocusedBorderColor = Color.LightGray,
            focusedLabelColor = Color(0xFFA370EE),
            cursorColor = Color(0xFFA370EE),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
        ),
    )
}