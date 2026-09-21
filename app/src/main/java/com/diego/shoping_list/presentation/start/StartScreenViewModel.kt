package com.diego.shoping_list.presentation.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diego.shoping_list.domain.use_cases.WarmUpDatabaseUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class StartScreenViewModel(
    private val dbWarmer: WarmUpDatabaseUseCase
) : ViewModel() {
    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    init {
        warmUp()
    }

    private fun warmUp() {
        viewModelScope.launch {
            val minDelay = async { delay(1_500L.milliseconds) }
            val warmUp = async { dbWarmer() }

            minDelay.await()
            warmUp.await()

            _isReady.value = true
        }
    }
}