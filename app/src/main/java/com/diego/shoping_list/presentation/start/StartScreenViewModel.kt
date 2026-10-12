package com.diego.shoping_list.presentation.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.domain.interactor.AuthInteractor
import com.diego.shoping_list.domain.use_cases.WarmUpDatabaseUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

enum class StartDestination {
    AUTH,
    MAIN
}

class StartScreenViewModel(
    private val dbWarmer: WarmUpDatabaseUseCase,
    private val authInteractor: AuthInteractor
) : ViewModel() {
    private val _destination =
        MutableStateFlow<StartDestination?>(null)

    val destination: StateFlow<StartDestination?> =
        _destination.asStateFlow()

    init {
        initialize()
    }

    private fun initialize() {
        viewModelScope.launch {
            val minDelay = async {
                delay(1_500L.milliseconds)
            }

            val warmUp = async {
                dbWarmer()
            }

            val restoreSession = async {
                authInteractor.restoreSession()
            }

            minDelay.await()
            warmUp.await()

            val isAuthenticated = restoreSession.await()

            _destination.value = if (isAuthenticated) {
                StartDestination.MAIN
            } else {
                StartDestination.AUTH
            }
        }
    }
}