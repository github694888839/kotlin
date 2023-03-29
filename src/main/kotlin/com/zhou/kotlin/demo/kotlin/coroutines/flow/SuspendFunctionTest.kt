package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
然而，计算过程阻塞运行该代码的主线程。 当这些值由异步代码计算时，我们可以使用 suspend 修饰符标记函数 simple，
这样它就可以在不阻塞的情况下执行其工作并将结果作为列表返回：
 */
fun main() = runBlocking {
    simpleSuspendList().forEach { value ->
        println("value is $value")
    }
}

suspend fun simpleSuspendList(): MutableList<Int> {
    delay(1000)
    return mutableListOf<Int>(1, 2, 3)
}