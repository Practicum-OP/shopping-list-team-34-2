package com.diego.shoping_list.domain.mapper

import com.diego.shoping_list.data.network.api.ApiResult
import com.diego.shoping_list.data.network.model.AuthResponse
import com.diego.shoping_list.data.network.model.RefreshResponse
import com.diego.shoping_list.domain.model.AuthError
import com.diego.shoping_list.domain.model.AuthSession
import com.diego.shoping_list.domain.model.DomainResult

fun AuthResponse.toSession() = AuthSession(
    accessToken = accessToken,
    refreshToken = refreshToken,
    userId = userId,
)

fun RefreshResponse.toSession(userId: Long) = AuthSession(
    accessToken = accessToken,
    refreshToken = refreshToken,
    userId = userId,
)

fun <T> ApiResult<T>.toDomain(map: (T) -> AuthSession): DomainResult<AuthSession> = when (this) {
    is ApiResult.Success -> DomainResult.Success(map(data))
    is ApiResult.ServerError -> DomainResult.Failure(AuthError.Server(code, message))
    is ApiResult.NetworkError -> DomainResult.Failure(AuthError.Network)
    is ApiResult.Unexpected -> DomainResult.Failure(AuthError.Unknown)
}