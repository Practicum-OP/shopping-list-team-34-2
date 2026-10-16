package com.diego.shoping_list.domain.model

sealed interface AuthError {
    data object InvalidCredentials : AuthError
    data object EmailAlreadyUsed : AuthError
    data object Network : AuthError
    data class Server(val code: String, val message: String) : AuthError
    data object Unknown : AuthError
}