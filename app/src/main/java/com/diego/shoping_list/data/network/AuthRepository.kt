package com.diego.shoping_list.data.network

import com.diego.shoping_list.data.network.api.ApiResult
import com.diego.shoping_list.data.network.model.AuthResponse
import com.diego.shoping_list.data.network.model.CheckResponse
import com.diego.shoping_list.data.network.model.RefreshResponse

interface AuthRepository {
    suspend fun register(email: String, password: String): ApiResult<AuthResponse>
    suspend fun login(email: String, password: String): ApiResult<AuthResponse>
    suspend fun refresh(refreshToken: String): ApiResult<RefreshResponse>
    suspend fun check(): ApiResult<CheckResponse>
    suspend fun recover(email: String): ApiResult<Unit>
}