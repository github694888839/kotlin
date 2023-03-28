package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {//在runBlocking中启动一个新协程
        delay(2000L)
        println("world")
    }
    println("hello")
}