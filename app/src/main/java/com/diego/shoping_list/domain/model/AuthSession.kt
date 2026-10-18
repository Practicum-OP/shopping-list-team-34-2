package com.diego.shoping_list.domain.model

data class AuthSession(
    val accessToken: String,
    val refreshToken: String,
    val userId: Long,
)