package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * 超时 withTimeout throw TimeoutCancellationException
 */
fun main() = runBlocking {
    withTimeout(1300L) {
        repeat(1000) {
            println("I'm sleeping  $it")
            delay(500)
        }
    }
}