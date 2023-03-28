package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {//开启主协程
    GlobalScope.launch {
        delay(1000)
        println("world")
    }
    println("hello")
    delay(2000L)//保证主协程存活2秒
}