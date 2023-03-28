package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    GlobalScope.launch {//后台启动一个协程
        delay(1000L)//非阻塞等待1秒
        println("world")//延迟后打印
    }
    println("hello")//协程在等待，main继续
    runBlocking {//阻塞主线程2秒
        delay(2000L)
    }
}