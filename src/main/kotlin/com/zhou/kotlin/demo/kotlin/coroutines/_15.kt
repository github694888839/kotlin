package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * 超时 withTimeoutOrNull
 */
fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) {
            println("I'm sleeping  $it")
            delay(500)
        }
        "Done"
    }
    println("Result is $result")
}