package com.diego.shoping_list.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.data.network.AuthRepository
import com.diego.shoping_list.data.network.api.ApiResult
import com.diego.shoping_list.data.network.model.AuthResponse
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    private val _effects = Channel<AuthEffect>(Channel.BUFFERED)
    val effects = _effects.receiveAsFlow()

    fun onIntent(intent: AuthIntent) {
        when (intent) {
            AuthIntent.Submit -> submit()
            else -> _state.update { it.reduce(intent) }
        }
    }

    private fun submit() {
        val current = _state.value
        if (!current.isSubmitEnabled) return

        _state.update { it.reduce(AuthIntent.Submit) }

        viewModelScope.launch {
            val result = when (current.screen) {
                AuthScreens.LOGIN -> repository.login(current.email, current.password)
                AuthScreens.REGISTRATION -> repository.register(current.email, current.password)
            }
            handleResult(result, current.screen)
        }
    }

    private suspend fun handleResult(
        result: ApiResult<AuthResponse>,
        screen: AuthScreens,
    ) {
        when (result) {
            is ApiResult.Success -> {
                if (screen == AuthScreens.LOGIN) {
                    _state.update {
                        it.copy(isLoading = false, generalError = null)
                    }
                    _effects.send(AuthEffect.NavigateToMain(result.data))
                } else {

                    _state.update {
                        AuthState(
                            screen = AuthScreens.LOGIN,
                            email = it.email,
                        )
                    }
                    _effects.send(
                        AuthEffect.ShowSnackbar("Аккаунт зарегистрирован! Войдите.")
                    )
                }
            }

            is ApiResult.ServerError -> fail(result.message)
            is ApiResult.NetworkError -> fail("Проверьте интернет")
            is ApiResult.Unexpected -> fail("Что-то пошло не так")
        }
    }

    private suspend fun fail(message: String) {
        _state.update { it.copy(isLoading = false, generalError = message) }
        _effects.send(AuthEffect.ShowSnackbar(message))
    }
}

enum class AuthScreens { REGISTRATION, LOGIN }