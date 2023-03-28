package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * 运行不能取消的代码块  withContext(NonCancellable)
 */
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) {
                println("job: I'm sleeping  $it...")
                delay(500)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000)
                println("job: And I've just delayed for 1 sec because I'm non-cancelable.")
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting.")
    job.cancelAndJoin()
    println("main: I can quit.")
}