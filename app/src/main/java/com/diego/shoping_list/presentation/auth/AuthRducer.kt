package com.diego.shoping_list.presentation.auth

import android.util.Patterns

const val MIN_PASSWORD_LENGTH = 7

fun AuthState.reduce(intent: AuthIntent): AuthState = when (intent) {
    is AuthIntent.EmailChanged -> reduceEmailChanged(intent.value)
    is AuthIntent.PasswordChanged -> reducePasswordChanged(intent.value)
    is AuthIntent.ConfirmPasswordChanged -> reduceConfirmPasswordChanged(intent.value)
    is AuthIntent.RememberMeChanged -> reduceRememberMeChanged(intent.value)
    is AuthIntent.EmailFocusChanged -> reduceEmailFocusChanged(intent.isFocused)
    is AuthIntent.PasswordFocusChanged -> reducePasswordFocusChanged(intent.isFocused)
    AuthIntent.TogglePasswordVisibility -> reduceTogglePasswordVisibility()
    AuthIntent.Submit -> reduceSubmit()
    is AuthIntent.SwitchScreen -> reduceSwitchScreen(intent.screen)
    AuthIntent.ErrorShown -> reduceErrorShown()
}

private fun AuthState.reduceEmailChanged(value: String): AuthState = copy(
    email = value,
    emailError = validateEmail(value),
    generalError = null,
)

private fun AuthState.reducePasswordChanged(value: String): AuthState = copy(
    password = value,
    passwordError = validatePassword(
        password = value,
        confirm = confirmPassword,
        screen = screen,
    ),
    generalError = null,
)

private fun AuthState.reduceConfirmPasswordChanged(value: String): AuthState = copy(
    confirmPassword = value,
    passwordError = validatePassword(
        password = password,
        confirm = value,
        screen = screen,
    ),
)

private fun AuthState.reduceRememberMeChanged(value: Boolean): AuthState = copy(
    rememberMe = value,
)

private fun AuthState.reduceEmailFocusChanged(isFocused: Boolean): AuthState =
    if (!isFocused && email.isNotBlank()) {
        copy(emailError = validateEmail(email))
    } else {
        this
    }

private fun AuthState.reducePasswordFocusChanged(isFocused: Boolean): AuthState =
    if (!isFocused && password.isNotBlank()) {
        copy(passwordError = validatePassword(password, confirmPassword, screen))
    } else {
        this
    }

private fun AuthState.reduceTogglePasswordVisibility(): AuthState = copy(
    isPasswordVisible = !isPasswordVisible,
)

private fun AuthState.reduceSubmit(): AuthState = copy(
    isLoading = true,
    generalError = null,
)

private fun AuthState.reduceSwitchScreen(newScreen: AuthScreens): AuthState = AuthState(
    screen = newScreen,
    email = email,
)

private fun AuthState.reduceErrorShown(): AuthState = copy(
    generalError = null,
)

private fun validateEmail(value: String): String? = when {
    value.isBlank() -> null
    !Patterns.EMAIL_ADDRESS.matcher(value).matches() -> "Некорректный email"
    else -> null
}

private fun validatePassword(
    password: String,
    confirm: String,
    screen: AuthScreens,
): String? = when {
    password.isBlank() -> null
    password.length < MIN_PASSWORD_LENGTH ->
        "Пароль должен быть не короче $MIN_PASSWORD_LENGTH символов"
    screen == AuthScreens.REGISTRATION && confirm.isNotBlank() && confirm != password ->
        "Пароли не совпадают"
    else -> null
}