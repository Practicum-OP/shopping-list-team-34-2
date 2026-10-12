package com.diego.shoping_list.domain.repository

import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.AuthTokens

interface SessionRepository {

    suspend fun saveSession(session: AuthSession)

    suspend fun getSession(): AuthSession?

    suspend fun updateTokens(
        accessToken: String,
        refreshToken: String
    ): AuthTokens

    suspend fun saveRememberMe(remember: Boolean)

    suspend fun shouldRememberMe(): Boolean

    suspend fun clearSession()
}
