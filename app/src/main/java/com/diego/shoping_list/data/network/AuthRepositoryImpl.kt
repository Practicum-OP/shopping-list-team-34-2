package com.diego.shoping_list.data.network

import com.diego.shoping_list.data.network.api.ApiResult
import com.diego.shoping_list.data.network.api.ApiService
import com.diego.shoping_list.data.network.model.ApiError
import com.diego.shoping_list.data.network.model.AuthRequest
import com.diego.shoping_list.data.network.model.RecoveryRequest
import com.diego.shoping_list.data.network.model.RefreshRequest
import com.diego.shoping_list.domain.mapper.toDomain
import com.diego.shoping_list.domain.mapper.toSession
import com.diego.shoping_list.domain.model.AuthError
import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.DomainResult
import com.diego.shoping_list.domain.repository.AuthRepository
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: ApiService,
    private val gson: Gson
) : AuthRepository {
    override suspend fun register(email: String, password: String): DomainResult<AuthSession> =
        safeCall { api.register(AuthRequest(email, password)) }.toDomain { it.toSession() }


    override suspend fun login(email: String, password: String ): DomainResult<AuthSession> =
        safeCall { api.login(AuthRequest(email, password)) }.toDomain { it.toSession() }

    override suspend fun refresh(refreshToken: String): DomainResult<AuthSession> =
        safeCall { api.refresh(RefreshRequest(refreshToken)) }.toDomain { it.toSession(userId = -1) }

    override suspend fun check(accessToken: String?): DomainResult<Boolean> =
        when (val result = safeCall { api.check(accessToken) }) {
            is ApiResult.Success -> DomainResult.Success(result.data.isValid)
            is ApiResult.ServerError -> DomainResult.Failure(AuthError.Server(result.code, result.message))
            is ApiResult.NetworkError -> DomainResult.Failure(AuthError.Network)
            is ApiResult.Unexpected -> DomainResult.Failure(AuthError.Unknown)
        }

    override suspend fun recover(email: String): DomainResult<Unit> =
        when (val result = safeCall { api.recover(RecoveryRequest(email)) }) {
            is ApiResult.Success -> DomainResult.Success(Unit)
            is ApiResult.ServerError -> DomainResult.Failure(AuthError.Server(result.code, result.message))
            is ApiResult.NetworkError -> DomainResult.Failure(AuthError.Network)
            is ApiResult.Unexpected -> DomainResult.Failure(AuthError.Unknown)
        }


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
