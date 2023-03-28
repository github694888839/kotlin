package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * 协程很轻量
 */
fun main() = runBlocking {
    repeat(100_00) {
        launch {
            delay(5000)
            print(".")
        }
    }
}