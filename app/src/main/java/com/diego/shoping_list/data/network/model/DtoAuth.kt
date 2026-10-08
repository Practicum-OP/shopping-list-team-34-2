package com.diego.shoping_list.data.network.model

import com.google.gson.annotations.SerializedName

data class AuthRequest(
    val email: String,
    val password: String
)

data class RefreshRequest(
    @SerializedName("refresh_token") val refreshToken: String
)

data class RecoveryRequest(
    val email: String
)

data class AuthResponse(
    @SerializedName("access_token")  val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("user_id")       val userId: Long
)

data class RefreshResponse(
    @SerializedName("access_token")  val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String
)

data class CheckResponse(
    @SerializedName("is_valid") val isValid: Boolean
)

data class ApiError(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
)
