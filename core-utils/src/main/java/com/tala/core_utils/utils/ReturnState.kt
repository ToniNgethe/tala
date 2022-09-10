package com.tala.core_utils.utils

sealed class ReturnState<T> {
    data class ErrorState<T>(val message: String) : ReturnState<T>()
    data class SuccessState<T>(val data: T) : ReturnState<T>()
}