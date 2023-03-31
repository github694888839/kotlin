package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

/**
 * 流的上下文
 * 流的收集总是在调用协程的上下文中发生。
 */
fun main() = runBlocking {
    simpleContextFlow().collect {
        println("value is $it")
    }
}

private suspend fun simpleContextFlow() = flow<Int> {
    println("Started simple Flow")
    for (i in 1..3) {
        emit(i)
    }
}