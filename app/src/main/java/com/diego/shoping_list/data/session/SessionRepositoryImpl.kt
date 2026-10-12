package com.diego.shoping_list.data.session

import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.AuthTokens
import com.diego.shoping_list.domain.repository.SessionRepository

class SessionRepositoryImpl(
    private val localDataSource: SessionLocalDataSource
) : SessionRepository {

    override suspend fun saveSession(session: AuthSession) {
        localDataSource.saveSession(
            accessToken = session.accessToken,
            refreshToken = session.refreshToken,
            userId = session.userId
        )
    }

    override suspend fun getSession(): AuthSession? {
        val accessToken = localDataSource.getAccessToken()
            ?: return null

        val refreshToken = localDataSource.getRefreshToken()
            ?: return null

        val userId = localDataSource.getUserId()

        if (userId == -1L) return null

        return AuthSession(
            accessToken = accessToken,
            refreshToken = refreshToken,
            userId = userId
        )
    }

    override suspend fun updateTokens(
        accessToken: String,
        refreshToken: String
    ): AuthTokens {
        val userId = localDataSource.getUserId()

        check(userId != -1L) { "Cannot update tokens: userId is missing" }

        localDataSource.saveSession(
            accessToken = accessToken,
            refreshToken = refreshToken,
            userId = userId
        )

        return AuthTokens(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    override suspend fun saveRememberMe(remember: Boolean) {
        localDataSource.saveRememberMe(remember)
    }

    override suspend fun shouldRememberMe(): Boolean {
        return localDataSource.shouldRememberMe()
    }

    override suspend fun clearSession() {
        localDataSource.clearSession()
    }
}