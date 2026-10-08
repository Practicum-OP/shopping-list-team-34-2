package com.diego.shoping_list.domain.repository

import com.diego.shoping_list.domain.model.AuthSession

interface SessionRepository {
    suspend fun saveSession(data: AuthSession)
    suspend fun getAccessTokenForInternalStorage(): String?
    val isLoggedIn: Boolean
}