package com.diego.shoping_list.domain.repository

import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.DomainResult

interface AuthRepository {
    suspend fun register(email: String, password: String): DomainResult<AuthSession>
    suspend fun login(email: String, password: String): DomainResult<AuthSession>
    suspend fun refresh(refreshToken: String): DomainResult<AuthSession>
    suspend fun check(accessToken: String?): DomainResult<Boolean>
    suspend fun recover(email: String): DomainResult<Unit>
}