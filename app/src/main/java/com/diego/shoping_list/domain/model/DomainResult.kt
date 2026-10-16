package com.diego.shoping_list.domain.model

sealed interface DomainResult<out T> {
    data class Success<T>(val data: T) : DomainResult<T>
    data class Failure(val error: AuthError) : DomainResult<Nothing>
}
