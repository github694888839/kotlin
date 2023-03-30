package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/*流取消基础
流采用与协程同样的协作取消。像往常一样，流的收集可以在当流在一个可取消的挂起函数（例如 delay）中挂起的时候取消。
以下示例展示了当 withTimeoutOrNull 块中代码在运行的时候流是如何在超时的情况下取消并停止执行其代码的：*/
fun main(): Unit = runBlocking {
    withTimeoutOrNull(2500) {
        simpleFlowForCancel().collect { value -> println("value is $value") }
    }
    println("done")
}

fun simpleFlowForCancel() = flow<Int> {
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}