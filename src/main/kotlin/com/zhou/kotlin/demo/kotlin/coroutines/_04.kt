package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    val job = GlobalScope.launch {//开启一个协程
        delay(1000L)
        println("world")
    }
    println("hello")
    job.join()//直到job结束工作
}