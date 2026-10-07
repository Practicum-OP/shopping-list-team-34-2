package com.diego.shoping_list.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.network.AuthRepository
import com.diego.shoping_list.data.network.api.ApiResult
import com.diego.shoping_list.data.network.model.AuthResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AuthUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isLoggedIn: Boolean = false,
    val result: ApiResult<AuthResponse>? = null,
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val screen: AuthScreens = AuthScreens.LOGIN
)

class AuthViewModel(
    private val repository: AuthRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(AuthUiState())
    val state: StateFlow<AuthUiState> = _state.asStateFlow()

    fun login(email: String, password: String) = submit { repository.login(email, password) }

    fun register(email: String, password: String) {
        if (_state.value.isLoggedIn) return
        submit { repository.register(email, password) }
    }

    private fun submit(request: suspend () -> ApiResult<AuthResponse>) {
        _state.update { it.copy(isLoading = true, errorMessage = null) }
        viewModelScope.launch {
            val result = request()
            _state.update { current ->
                when (result) {
                    is ApiResult.Success -> current.copy(
                        isLoading = false,
                        isLoggedIn = true,
                        result = result,
                        screen = AuthScreens.LOGIN,
                        errorMessage = "Аккаунт зарегестрирован!"
                    )
                    is ApiResult.ServerError -> current.copy(
                        isLoading = false,
                        errorMessage = result.message,
                        result = result,
                    )
                    is ApiResult.NetworkError -> current.copy(
                        isLoading = false,
                        errorMessage = "Проверьте интернет",
                        result = result,
                    )
                    is ApiResult.Unexpected -> current.copy(
                        isLoading = false,
                        errorMessage = "Что-то пошло не так",
                        result = result,
                    )
                }
            }
        }
    }

    fun setScreen(screen: AuthScreens) {
        _state.update { it.copy(screen = screen) }
    }

    fun setEmail(email: String) = _state.update { it.copy(email = email, errorMessage = null) }

    fun setEmailError(error: String?) = _state.update { it.copy(emailError = error) }

    fun setPassword(password: String) = _state.update { it.copy(password = password, errorMessage = null) }

    fun setPasswordError(error: String?) = _state.update { it.copy(passwordError = error) }

    fun clearErrors() = _state.update {
        it.copy(emailError = null, passwordError = null, errorMessage = null)
    }
}

enum class AuthScreens() {
    REGISTRATION,
    LOGIN
}