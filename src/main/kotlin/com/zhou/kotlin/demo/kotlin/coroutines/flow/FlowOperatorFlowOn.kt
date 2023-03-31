package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * flowOn 操作符
例外的是 flowOn 函数，该函数用于更改流发射的上下文。
以下示例展示了更改流上下文的正确方法，
该示例还通过打印相应线程的名字以展示它们的工作方式：
 */

fun simpleFlowOn() = flow<Int> {
    for (i in 1..5) {
        Thread.sleep(100)
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    simpleFlowOn().collect { value ->
        println(value)
    }
}