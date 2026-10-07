package com.diego.shoping_list.data.network.api

import com.diego.shoping_list.data.network.model.AuthRequest
import com.diego.shoping_list.data.network.model.AuthResponse
import com.diego.shoping_list.data.network.model.CheckResponse
import com.diego.shoping_list.data.network.model.RecoveryRequest
import com.diego.shoping_list.data.network.model.RefreshRequest
import com.diego.shoping_list.data.network.model.RefreshResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/registration")
    suspend fun register(@Body body: AuthRequest): AuthResponse

    @POST("auth/login")
    suspend fun login(@Body body: AuthRequest): AuthResponse

    @POST("auth/refresh")
    suspend fun refresh(@Body body: RefreshRequest): RefreshResponse

    @GET("auth/check")
    suspend fun check(accessToken: String?): CheckResponse

    @POST("auth/recovery")
    suspend fun recover(@Body email: RecoveryRequest)
}

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class ServerError(val code: String, val message: String) : ApiResult<Nothing>
    data class NetworkError(val cause: Throwable) : ApiResult<Nothing>
    data class Unexpected(val httpCode: Int?, val cause: Throwable?) : ApiResult<Nothing>
}