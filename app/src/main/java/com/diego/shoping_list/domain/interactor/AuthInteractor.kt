package com.diego.shoping_list.domain.interactor

import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.DomainResult
import com.diego.shoping_list.domain.repository.AuthRepository
import com.diego.shoping_list.domain.repository.SessionRepository

class AuthInteractor(
    private val authRepository: AuthRepository,
    private val sessionRepository: SessionRepository,
) {
    suspend fun login(email: String, password: String): DomainResult<AuthSession> {
        val result = authRepository.login(email.trim(), password)
        if (result is DomainResult.Success) {
            sessionRepository.saveSession(result.data)
        }
        return result
    }

    suspend fun register(email: String, password: String): DomainResult<AuthSession> =
        authRepository.register(email.trim(), password)

    suspend fun checkSession(): Boolean {
        val accessToken = sessionRepository.getAccessTokenForInternalStorage()
        return when (val result = authRepository.check(accessToken)) {
            is DomainResult.Success -> true
            is DomainResult.Failure -> false
        }
    }
}