package com.tala.core_utils.utils

import kotlinx.coroutines.Dispatchers

class AppDispatchersImpl : AppDispatchers {
    override fun main() = Dispatchers.Main

    override fun io() = Dispatchers.IO

    override fun default() = Dispatchers.Default
}