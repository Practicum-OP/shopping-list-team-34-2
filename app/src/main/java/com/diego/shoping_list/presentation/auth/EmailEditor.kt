package com.diego.shoping_list.presentation.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

private val AccentColor = Color(0xFFA370EE)
private val MutedBorderColor = Color.LightGray

@Composable
fun EmailEditor(
    state: AuthState,
    onIntent: (AuthIntent) -> Unit,
    focusManager: FocusManager,
) {
    OutlinedTextField(
        value = state.email,
        onValueChange = { onIntent(AuthIntent.EmailChanged(it)) },
        label = { Text("Email") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        isError = state.emailError != null,
        supportingText = state.emailError?.let { { Text(it) } },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .onFocusChanged {
                onIntent(AuthIntent.EmailFocusChanged(it.isFocused))
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