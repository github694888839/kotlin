package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow

/**
 * withContext 发出错误
然而，长时间运行的消耗 CPU 的代码也许需要在 Dispatchers.Default 上下文中执行，并且更新 UI 的代码也许需要在 Dispatchers.Main 中执行。
通常，withContext 用于在 Kotlin 协程中改变代码的上下文，但是 flow {...} 构建器中的代码必须遵循上下文保存属性，并且不允许从其他上下文中发射（emit）。
 */
fun simple() = flow<Int> {
    withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(1000)
            emit(i)
        }
    }
}

fun main() = runBlocking {
    simple().collect { value ->
        println(value)
    }
}