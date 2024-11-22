package com.ashrakat.tastetalk.base

import com.ashrakat.tastetalk.data.utilites.NetworkUtility
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler @Inject constructor(
    private val networkUtility: NetworkUtility
) {
    suspend fun <T> globalNetworkCall(
        action: suspend () -> T, doAfterSuccess: ((T) -> Unit)? = null
    ): DomainResult<T> {
        return try {
            if (!networkUtility.isInternetConnected()) return DomainResult.NetworkError
            val result = action.invoke()
            doAfterSuccess?.invoke(result)
            DomainResult.Success(result)
        } catch (e: Exception) {
            DomainResult.Error(e)
        }
    }

    suspend fun <T> transactionalCall(
        vararg actions: suspend () -> Any, doAfterSuccess: ((T) -> Unit)? = null
    ): DomainResult<T> {
        return try {
            if (!networkUtility.isInternetConnected()) return DomainResult.NetworkError
            var firstActionResult: T? = null
            for ((index, action) in actions.withIndex()) {
                val result = globalNetworkCall(action = action)
                if (result is DomainResult.Error) throw result.exception
                if (index == 0 && result is DomainResult.Success) {
                    firstActionResult = result.data as T
                    doAfterSuccess?.invoke(firstActionResult)
                }
            }
            DomainResult.Success(firstActionResult!!)
        } catch (e: Exception) {
            DomainResult.Error(e)
        }
    }
}


