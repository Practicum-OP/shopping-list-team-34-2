package com.diego.shoping_list.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.domain.interactor.AuthInteractor
import com.diego.shoping_list.domain.model.AuthError
import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.DomainResult
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val interactor: AuthInteractor,
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
                AuthScreens.LOGIN -> interactor.login(current.email, current.password)
                AuthScreens.REGISTRATION -> interactor.register(current.email, current.password)
            }
            handleResult(result, current.screen)
        }
    }

    private suspend fun handleResult(
        result: DomainResult<AuthSession>,
        screen: AuthScreens,
    ) {
        when (result) {
            is DomainResult.Success -> {
                if (screen == AuthScreens.LOGIN) {
                    _state.update {
                        it.copy(isLoading = false, generalError = null)
                    }
                    _effects.send(AuthEffect.NavigateToMain)
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

            is DomainResult.Failure -> fail(result.error.toMessage())
        }
    }

    private suspend fun fail(message: String) {
        _state.update { it.copy(isLoading = false, generalError = message) }
        _effects.send(AuthEffect.ShowSnackbar(message))
    }

    private fun AuthError.toMessage(): String = when (this) {
        AuthError.InvalidCredentials -> "Неверный email или пароль"
        AuthError.EmailAlreadyUsed -> "Этот email уже зарегистрирован"
        AuthError.Network -> "Проверьте интернет"
        is AuthError.Server -> message
        AuthError.Unknown -> "Что-то пошло не так"
    }
}

enum class AuthScreens { REGISTRATION, LOGIN }