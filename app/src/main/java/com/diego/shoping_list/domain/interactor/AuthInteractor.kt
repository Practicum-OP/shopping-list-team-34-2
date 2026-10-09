package com.diego.shoping_list.domain.interactor

import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.DomainResult
import com.diego.shoping_list.domain.repository.AuthRepository
import com.diego.shoping_list.domain.repository.SessionRepository

class AuthInteractor(
    private val authRepository: AuthRepository,
    private val sessionRepository: SessionRepository,
) {
    suspend fun register(email: String, password: String): DomainResult<AuthSession> {
        val result = authRepository.register(email.trim(), password)
        if (result is DomainResult.Success) {
            sessionRepository.saveSession(result.data)
        }
        return result
    }
    suspend fun login(email: String, password: String): DomainResult<AuthSession> {
        val result = authRepository.login(email.trim(), password)
        if (result is DomainResult.Success) {
            sessionRepository.saveSession(result.data)
        }
        return result
    }
    suspend fun restoreSession(): Boolean {
        val session = sessionRepository.getSession() ?: return false

        val checkResult = authRepository.check(session.accessToken)
        if (checkResult is DomainResult.Success && checkResult.data) {
            return true   // токен ещё жив
        }

        val refreshResult = authRepository.refresh(session.refreshToken)
        return when (refreshResult) {
            is DomainResult.Success -> {
                sessionRepository.updateTokens(
                    accessToken = refreshResult.data.accessToken,
                    refreshToken = refreshResult.data.refreshToken,
                )
                true
            }
            is DomainResult.Failure -> {
                sessionRepository.clearSession()
                false
            }
        }
    }

    suspend fun recover(email: String): DomainResult<Unit> =
        authRepository.recover(email.trim())

    suspend fun logout() {
        sessionRepository.clearSession()
    }
}