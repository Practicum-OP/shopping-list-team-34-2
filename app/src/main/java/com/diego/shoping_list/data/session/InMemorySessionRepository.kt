package com.diego.shoping_list.data.session

import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.repository.SessionRepository

class InMemorySessionRepository : SessionRepository {

    @Volatile
    private var session: AuthSession? = null

    override suspend fun saveSession(session: AuthSession) {
        this.session = session
    }

    override suspend fun getSession(): AuthSession? = session

    override suspend fun updateTokens(accessToken: String, refreshToken: String) {
        val current = session ?: return
        session = current.copy(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

    override suspend fun clearSession() {
        session = null
    }
}