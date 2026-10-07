package com.diego.shoping_list.data.network

import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.repository.SessionRepository

class SessionRepositoryImpl(
//    private val dataStore: DataStore<Preferences>
): SessionRepository {
    var session: AuthSession? = null

    override suspend fun saveSession(data: AuthSession) {
        session = data
    }

    override suspend fun getAccessTokenForInternalStorage(): String? {
        return session?.accessToken
    }

    override val isLoggedIn = false
}