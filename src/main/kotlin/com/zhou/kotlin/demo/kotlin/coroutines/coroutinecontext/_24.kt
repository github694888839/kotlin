package com.zhou.kotlin.demo.kotlin.coroutines.coroutinecontext

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * 调度器与线程
 */
fun main() = runBlocking<Unit> {
    launch {//主线程里面
        println("I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {//不受限的，将工作在主线程
        println("Unconfined: I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {//将会获取默认调度器
        println("Default: I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("new Thread")) {//将使他获得一个新的线程
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}