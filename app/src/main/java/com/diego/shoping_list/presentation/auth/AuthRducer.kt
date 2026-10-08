package com.diego.shoping_list.presentation.auth

import android.util.Patterns

const val MIN_PASSWORD_LENGTH = 7

fun AuthState.reduce(intent: AuthIntent): AuthState = when (intent) {
    is AuthIntent.EmailChanged -> copy(
        email = intent.value,
        emailError = validateEmail(intent.value),
        generalError = null,
    )

    is AuthIntent.PasswordChanged -> copy(
        password = intent.value,
        passwordError = validatePassword(
            password = intent.value,
            confirm = confirmPassword,
            screen = screen,
        ),
        generalError = null,
    )

    is AuthIntent.ConfirmPasswordChanged -> copy(
        confirmPassword = intent.value,
        passwordError = validatePassword(
            password = password,
            confirm = intent.value,
            screen = screen,
        ),
    )

    is AuthIntent.EmailFocusChanged -> if (!intent.isFocused && email.isNotBlank()) {
        copy(emailError = validateEmail(email))
    } else this

    is AuthIntent.PasswordFocusChanged -> if (!intent.isFocused && password.isNotBlank()) {
        copy(passwordError = validatePassword(password, confirmPassword, screen))
    } else this

    AuthIntent.TogglePasswordVisibility -> copy(isPasswordVisible = !isPasswordVisible)

    AuthIntent.Submit -> copy(isLoading = true, generalError = null)

    is AuthIntent.SwitchScreen -> AuthState(
        screen = intent.screen,
        email = email,
    )

    AuthIntent.ErrorShown -> copy(generalError = null)
}

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