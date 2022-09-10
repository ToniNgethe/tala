package com.tala.core_utils.utils

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    fun main(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
}
