package com.zhou.kotlin.demo.kotlin.coroutines.coroutinecontext

import kotlinx.coroutines.*

/**
 *给协程命名，方便调试
 */
fun main() = runBlocking<Unit> {
    println("Started main coroutine.")
    val c1 = async(CoroutineName("c1")) {
        delay(500)
        println("Computing in c1")
        252
    }
    val c2 = async(CoroutineName("c2")) {
        delay(500)
        println("Computing in c2")
        6
    }
    println("The answer is ${c1.await().plus(c2.await())}")
    //组合上下文多个元素
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}