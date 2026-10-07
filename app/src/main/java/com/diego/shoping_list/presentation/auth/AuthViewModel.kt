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
    val passwordError: String = "",
)

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AuthUiState())
    val state: StateFlow<AuthUiState> = _state.asStateFlow()

    fun login(email: String, password: String) {
        _state.update { it.copy(isLoading = true, errorMessage = null) }
        viewModelScope.launch {
            when (val result = repository.login(email, password)) {
                is ApiResult.Success -> {
                    _state.update { it.copy(isLoading = false, isLoggedIn = true, result = result) }
                }
                is ApiResult.ServerError -> {
                    _state.update { it.copy(isLoading = false, errorMessage = result.message) }
                }
                is ApiResult.NetworkError -> {
                    _state.update { it.copy(isLoading = false, errorMessage = "Проверьте интернет") }
                }
                is ApiResult.Unexpected -> {
                    _state.update { it.copy(isLoading = false, errorMessage = "Что-то пошло не так") }
                }
            }
        }
    }

    fun register(email: String, password: String) {
        _state.update { it.copy(isLoading = true, errorMessage = null) }
        viewModelScope.launch {
            when (val result = repository.register(email, password)) {
                is ApiResult.Success -> {
                    _state.update { it.copy(isLoading = false, isLoggedIn = true, result = result) }
                }
                is ApiResult.ServerError -> {
                    _state.update { it.copy(isLoading = false, errorMessage = result.message) }
                }
                is ApiResult.NetworkError -> {
                    _state.update { it.copy(isLoading = false, errorMessage = "Проверьте интернет") }
                }
                is ApiResult.Unexpected -> {
                    _state.update { it.copy(isLoading = false, errorMessage = "Что-то пошло не так") }
                }
            }
        }
    }

    fun setEmail(email: String) {
        _state.update {it.copy(email = email)}
    }

    fun setEmailError(emailError: String?) {
        _state.update {it.copy(emailError = emailError)}
    }

    fun setPassword(password: String) {
        _state.update { it.copy(password = password) }
    }

    fun setPasswordError(error: String?) {
        _state.update { it.copy(passwordError = error ?: "") }
    }
}