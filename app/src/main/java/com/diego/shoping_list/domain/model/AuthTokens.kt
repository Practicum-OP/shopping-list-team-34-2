package com.diego.shoping_list.domain.model

data class AuthTokens(
    val accessToken: String,
    val refreshToken: String,
)
