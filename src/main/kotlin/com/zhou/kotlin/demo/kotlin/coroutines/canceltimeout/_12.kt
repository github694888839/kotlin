package com.zhou.kotlin.demo.kotlin.coroutines.canceltimeout

import kotlinx.coroutines.*

/**
 * 在 finally 中释放资源
 */
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) {
                println("job: I'm sleeping $it...")
                delay(500)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting..")
    job.cancelAndJoin()
    println("main: I can quit.")
}