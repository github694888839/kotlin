package com.zhou.kotlin.demo.kotlin.coroutines.basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000)
        println("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(1000)
            println("Task from nested launch")
        }
        delay(1000)
        println("Task from coroutine scope")
    }

    println("Coroutine scope is over")
}