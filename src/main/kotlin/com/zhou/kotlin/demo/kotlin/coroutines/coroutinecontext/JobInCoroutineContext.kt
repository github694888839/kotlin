package com.zhou.kotlin.demo.kotlin.coroutines.coroutinecontext

import kotlinx.coroutines.*

/**
 * 在不同线程间跳转
 *
 */
fun main() = runBlocking<Unit> {
    newSingleThreadContext("ctx1").use { ctx1 ->
        newSingleThreadContext("ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                println("started in ctx1")
                withContext(ctx2) {
                    println("work in ctx2")
                }
                println("back to ctx1")
            }
        }
    }
}