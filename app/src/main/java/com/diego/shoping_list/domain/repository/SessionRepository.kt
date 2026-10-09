package com.diego.shoping_list.domain.repository

import com.diego.shoping_list.domain.model.AuthSession

interface SessionRepository {
    suspend fun saveSession(session: AuthSession)
    suspend fun getSession(): AuthSession?
    suspend fun updateTokens(accessToken: String, refreshToken: String)
    suspend fun clearSession()
}
