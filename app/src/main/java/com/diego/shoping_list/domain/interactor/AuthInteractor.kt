package com.diego.shoping_list.domain.interactor

import com.diego.shoping_list.domain.model.AuthError
import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.DomainResult
import com.diego.shoping_list.domain.repository.AuthRepository
import com.diego.shoping_list.domain.repository.SessionRepository

class AuthInteractor(
    private val authRepository: AuthRepository,
    private val sessionRepository: SessionRepository
) {

    suspend fun register(
        email: String,
        password: String
    ): DomainResult<AuthSession> {
        val result = authRepository.register(email.trim(), password)

        if (result is DomainResult.Success) {
            sessionRepository.saveSession(result.data)
        }

        return result
    }

    suspend fun login(
        email: String,
        password: String,
        rememberMe: Boolean
    ): DomainResult<AuthSession> {
        val result = authRepository.login(email.trim(), password)

        if (result is DomainResult.Success) {
            sessionRepository.saveSession(result.data)
            sessionRepository.saveRememberMe(rememberMe)
        }

        return result
    }

    suspend fun restoreSession(): Boolean {
        if (!sessionRepository.shouldRememberMe()) {
            return false
        }

        val session = sessionRepository.getSession() ?: return false

        val checkResult = authRepository.check(session.accessToken)

        if (checkResult is DomainResult.Success && checkResult.data) {
            return true
        }

        if (checkResult is DomainResult.Failure &&
            checkResult.error == AuthError.Network
        ) {
            return false
        }

        return when (val refreshResult =
            authRepository.refresh(session.refreshToken)
        ) {
            is DomainResult.Success -> {
                sessionRepository.updateTokens(
                    accessToken = refreshResult.data.accessToken,
                    refreshToken = refreshResult.data.refreshToken
                )
                true
            }

            is DomainResult.Failure -> {
                if (refreshResult.error != AuthError.Network) {
                    sessionRepository.clearSession()
                }
                false
            }
        }
    }

    suspend fun recover(email: String): DomainResult<Unit> {
        return authRepository.recover(email.trim())
    }

    suspend fun logout() {
        sessionRepository.clearSession()
    }
}