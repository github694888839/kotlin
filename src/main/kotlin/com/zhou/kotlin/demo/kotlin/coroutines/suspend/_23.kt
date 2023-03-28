package com.zhou.kotlin.demo.kotlin.coroutines.suspend

import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlin.system.measureTimeMillis

/**
 * 取消始终通过协程的层次结构来进行传递：请注意，如果其中一个子协程（即 two）失败，第一个 async 以及等待中的父协程都会被取消：
 */
fun main(): Unit = runBlocking {
    try {
        failedCombine()
    } catch (e: ArithmeticException) {
        println("get an arithmeticException")
    }
}

suspend fun failedCombine() = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE)
            50
        } finally {
            println("first is canceled")
        }
    }
    val two = async<Int> {
        println("second throw an exception.")
        throw ArithmeticException()
    }
    one.await() + two.await()
}