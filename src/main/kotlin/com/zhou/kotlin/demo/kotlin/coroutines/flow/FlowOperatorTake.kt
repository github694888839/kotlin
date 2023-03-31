package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

/**
 * 限长操作符
 */
fun main() = runBlocking {
    takeNumbers().take(2).collect {
        println("value is $it")
    }
}

suspend fun takeNumbers() = flow<Int> {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in take Numbers")
    }
}