package com.diego.shoping_list.presentation.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

private val AccentColor = Color(0xFFA370EE)
private val MutedBorderColor = Color.LightGray
private const val MIN_PASSWORD_LENGTH = 7
@Composable
fun PasswordEditor(
    viewModel: AuthViewModel,
    state: AuthUiState,
    singlePasswordMode: Boolean = false,
) {
    if (singlePasswordMode) {
        val keyboardController = LocalSoftwareKeyboardController.current
        SinglePasswordField(
            value = state.password,
            onValueChange = {
                viewModel.setPassword(it)
                if (state.passwordError != null) viewModel.setPasswordError(null)
            },
            onDone = { keyboardController?.hide() },
            isError = state.passwordError != null,
            supportingText = state.passwordError,
        )
        return
    }

    var passwordFirst by remember { mutableStateOf("") }
    var passwordSecond by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun validate() {
        val error = when {
            passwordSecond.isEmpty() -> null
            passwordSecond != passwordFirst -> "Пароли не совпадают"
            passwordFirst.length < MIN_PASSWORD_LENGTH ->
                "Пароль должен быть не короче $MIN_PASSWORD_LENGTH символов"
            else -> null
        }
        viewModel.setPasswordError(error)
    }

    SinglePasswordField(
        value = passwordFirst,
        onValueChange = { value ->
            passwordFirst = value
            viewModel.setPassword(value)
            validate()
        },
        label = "Password",
        imeAction = ImeAction.Next,
    )

    SinglePasswordField(
        value = passwordSecond,
        onValueChange = { value ->
            passwordSecond = value
            validate()
        },
        label = "Repeat password",
        imeAction = ImeAction.Done,
        onDone = {
            keyboardController?.hide()
            if (state.passwordError == null && passwordFirst.isNotBlank()) {
                viewModel.register(state.email, passwordFirst)
            }
        },
        isError = state.passwordError != null,
        supportingText = state.passwordError,
    )
}

@Composable
private fun SinglePasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Password",
    imeAction: ImeAction = ImeAction.Done,
    onDone: (() -> Unit)? = null,
    isError: Boolean = false,
    supportingText: String? = null,
) {
    var visible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        visualTransformation = if (visible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction,
        ),
        keyboardActions = KeyboardActions(onDone = { onDone?.invoke() }),
        isError = isError,
        supportingText = supportingText?.let { { Text(it) } },
        trailingIcon = {
            IconButton(onClick = { visible = !visible }) {
                Icon(
                    imageVector = if (visible) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff,
                    contentDescription = if (visible) "Скрыть пароль" else "Показать пароль",
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AccentColor,
            unfocusedBorderColor = MutedBorderColor,
            focusedLabelColor = AccentColor,
            cursorColor = AccentColor,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
        ),
    )
}