package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {//一个执行计算的循环，主要为了占用cpu
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++}...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300)
    println("main: I'm tired of waiting.")
    job.cancelAndJoin()
    println("main: Now I can quit.")

}