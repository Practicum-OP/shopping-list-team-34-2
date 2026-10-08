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
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

private val AccentColor = Color(0xFFA370EE)
private val MutedBorderColor = Color.LightGray

@Composable
fun PasswordEditor(
    state: AuthState,
    onIntent: (AuthIntent) -> Unit,
    singlePasswordMode: Boolean = false,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    SinglePasswordField(
        value = state.password,
        onValueChange = { onIntent(AuthIntent.PasswordChanged(it)) },
        label = "Password",
        imeAction = if (singlePasswordMode) ImeAction.Done else ImeAction.Next,
        onDone = {
            if (singlePasswordMode) {
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        },
        isVisible = state.isPasswordVisible,
        onToggleVisibility = { onIntent(AuthIntent.TogglePasswordVisibility) },
        isError = state.passwordError != null && singlePasswordMode,
        supportingText = if (singlePasswordMode) state.passwordError else null,
        onFocusChanged = { isFocused ->
            onIntent(AuthIntent.PasswordFocusChanged(isFocused))
        },
    )

    if (!singlePasswordMode) {
        SinglePasswordField(
            value = state.confirmPassword,
            onValueChange = { onIntent(AuthIntent.ConfirmPasswordChanged(it)) },
            label = "Repeat password",
            imeAction = ImeAction.Done,
            onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
            },
            isVisible = state.isPasswordVisible,
            onToggleVisibility = { onIntent(AuthIntent.TogglePasswordVisibility) },
            isError = state.passwordError != null,
            supportingText = state.passwordError,
            onFocusChanged = { isFocused ->
                onIntent(AuthIntent.PasswordFocusChanged(isFocused))
            },
        )
    }
}

@Composable
private fun SinglePasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Password",
    imeAction: ImeAction = ImeAction.Done,
    onDone: (() -> Unit)? = null,
    isVisible: Boolean,
    onToggleVisibility: () -> Unit,
    isError: Boolean = false,
    supportingText: String? = null,
    onFocusChanged: (Boolean) -> Unit = {},
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        visualTransformation = if (isVisible) {
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
            IconButton(onClick = onToggleVisibility) {
                Icon(
                    imageVector = if (isVisible) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff,
                    contentDescription = if (isVisible) "Скрыть пароль" else "Показать пароль",
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .onFocusChanged { focusState ->
                onFocusChanged(focusState.isFocused)
            },
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