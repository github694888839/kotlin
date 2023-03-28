package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * Refactor method suspend
 */
fun main() = runBlocking {
    launch {
        doWorld()
    }
    println("hello")
}

/**
 * suspend method
 */
private suspend fun doWorld() {
    delay(1000)
    println("world")
}