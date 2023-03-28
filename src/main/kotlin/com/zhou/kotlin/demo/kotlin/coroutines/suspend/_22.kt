package com.zhou.kotlin.demo.kotlin.coroutines.suspend

import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlin.system.measureTimeMillis

/**
使用 async 的结构化并发
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        val result = combineDoSomeOneAndTwo()
        println("result : $result")
    }

    println("Completed time is $time")

}

suspend fun combineDoSomeOneAndTwo(): Int = coroutineScope {
    val one = async {
        doSomethingUsefulOne()
    }
    val two = async {
        doSomethingUsefulTwo()
    }
    one.await() + two.await()
}