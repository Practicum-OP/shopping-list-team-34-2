package com.diego.shoping_list.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.network.AuthRepository
import com.diego.shoping_list.data.network.api.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AuthUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isLoggedIn: Boolean = false
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
                    _state.update { it.copy(isLoading = false, isLoggedIn = true) }
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
}