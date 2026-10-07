package com.diego.shoping_list.presentation.auth

import android.util.Patterns
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

private val AccentColor = Color(0xFFA370EE)
private val MutedBorderColor = Color.LightGray

@Composable
fun EmailEditor(
    viewModel: AuthViewModel,
    focusRequester: FocusRequester,
    focusManager: FocusManager,
    state: AuthUiState,
) {
    val isValidEmail = state.email.isNotBlank() &&
            Patterns.EMAIL_ADDRESS.matcher(state.email).matches()

    OutlinedTextField(
        value = state.email,
        onValueChange = { value ->
            viewModel.setEmail(value)
            if (state.emailError != null) viewModel.setEmailError(null)
        },
        label = { Text("Email") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                if (isValidEmail) {
                    viewModel.setEmailError(null)
                    focusManager.moveFocus(FocusDirection.Down)
                } else {
                    viewModel.setEmailError("Некорректный email")
                }
            }
        ),
        isError = state.emailError != null,
        supportingText = state.emailError?.let { { Text(it) } },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .onFocusChanged { focusState ->
                if (!focusState.isFocused && state.email.isNotBlank() && !isValidEmail) {
                    viewModel.setEmailError("Некорректный email")
                }
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