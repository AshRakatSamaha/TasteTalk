package com.ashrakat.tastetalk.base

sealed class DomainResult<out T> {
    data class Success<out T>(val data: T, var hasBeenHandled: Boolean = false) : DomainResult<T>()
    data class Error(val exception: Exception, var hasBeenHandled: Boolean = false) : DomainResult<Nothing>()
    object Loading : DomainResult<Nothing>()
    object NetworkError : DomainResult<Nothing>()
    object Empty : DomainResult<Nothing>()
}
