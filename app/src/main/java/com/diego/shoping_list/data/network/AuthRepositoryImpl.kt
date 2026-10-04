package com.diego.shoping_list.data.network

import com.diego.shoping_list.data.network.api.ApiResult
import com.diego.shoping_list.data.network.api.ApiService
import com.diego.shoping_list.data.network.model.ApiError
import com.diego.shoping_list.data.network.model.AuthRequest
import com.diego.shoping_list.data.network.model.AuthResponse
import com.diego.shoping_list.data.network.model.CheckResponse
import com.diego.shoping_list.data.network.model.RecoveryRequest
import com.diego.shoping_list.data.network.model.RefreshRequest
import com.diego.shoping_list.data.network.model.RefreshResponse
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: ApiService,
    private val gson: Gson
) : AuthRepository {
    override suspend fun register(email: String, password: String): ApiResult<AuthResponse> =
        safeCall { api.register(AuthRequest(email, password)) }


    override suspend fun login(email: String, password: String ): ApiResult<AuthResponse> =
        safeCall { api.login(AuthRequest(email, password)) }

    override suspend fun refresh(refreshToken: String): ApiResult<RefreshResponse> =
        safeCall { api.refresh(RefreshRequest(refreshToken)) }

    override suspend fun check(): ApiResult<CheckResponse> =
        safeCall { api.check() }

    override suspend fun recover(email: String): ApiResult<Unit> =
        safeCall { api.recover(RecoveryRequest(email)) }


    private suspend fun <T> safeCall(block: suspend () -> T): ApiResult<T> =
        try {
            ApiResult.Success(block())
        } catch (e: HttpException) {
            val apiError = parseApiError(e)
            if (apiError != null) {
                ApiResult.ServerError(apiError.code, apiError.message)
            } else {
                ApiResult.Unexpected(e.code(), e)
            }
        } catch (e: IOException) {
            ApiResult.NetworkError(e)
        } catch (e: Exception) {
            ApiResult.Unexpected(null, e)
        }

    private fun parseApiError(e: HttpException): ApiError? =
        e.response()?.errorBody()?.string()?.let { raw ->
            runCatching { gson.fromJson(raw, ApiError::class.java) }.getOrNull()
        }
}
