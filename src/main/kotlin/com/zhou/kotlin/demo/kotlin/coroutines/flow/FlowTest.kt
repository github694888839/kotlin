package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 使用 List 结果类型，意味着我们只能一次返回所有值。 为了表示异步计算的值流（stream），我们可以使用 Flow 类型（正如同步计算值会使用 Sequence 类型）：
 *
 * 注意使用 Flow 的代码与先前示例的下述区别：
 * 名为 flow 的 Flow 类型构建器函数。
 * flow { ... } 构建块中的代码可以挂起。
 * 函数 simple 不再标有 suspend 修饰符。
 * 流使用 emit 函数 发射 值。
 * 流使用 collect 函数 收集 值。
 */
fun main() = runBlocking {
    //启动对等线程，说明没有阻塞主线程
    launch {
        for (i in 1..3) {
            println("I'm blocked in $i")
            delay(1000)
        }
    }
    simpleFlow().collect { value ->
        println("value is $value")
    }
}

fun simpleFlow() = flow<Int> {
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}