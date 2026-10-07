package com.diego.shoping_list.presentation.auth

import com.diego.shoping_list.data.network.model.AuthResponse

sealed interface AuthIntent {
    data class EmailChanged(val value: String) : AuthIntent
    data class PasswordChanged(val value: String) : AuthIntent
    data class ConfirmPasswordChanged(val value: String) : AuthIntent
    data class EmailFocusChanged(val isFocused: Boolean) : AuthIntent
    data class PasswordFocusChanged(val isFocused: Boolean) : AuthIntent

    data object Submit : AuthIntent
    data object TogglePasswordVisibility : AuthIntent
    data class SwitchScreen(val screen: AuthScreens) : AuthIntent
    data object ErrorShown : AuthIntent
}

data class AuthState(
    val screen: AuthScreens = AuthScreens.LOGIN,
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val generalError: String? = null,
) {
    val isSubmitEnabled: Boolean
        get() = when {
            isLoading -> false
            email.isBlank() -> false
            password.isBlank() -> false
            emailError != null -> false
            passwordError != null -> false
            screen == AuthScreens.REGISTRATION -> confirmPassword == password
            else -> true
        }
}

sealed interface AuthEffect {
    data class ShowSnackbar(val message: String) : AuthEffect
    data class NavigateToMain(val auth: AuthResponse) : AuthEffect
}