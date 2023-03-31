package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.plus
import kotlinx.coroutines.runBlocking

/*
组合多个流
组合多个流有很多种方式。
zip
combine
 */
fun main() = runBlocking {
    val nums = (1..3).asFlow()
    val strings = flowOf("one", "two", "three")
    nums.zip(strings) { a, b -> "$a is $b" }.collect {
        println(it)
    }

    val nums2 = (1..3).asFlow().onEach { delay(100) }
    val strings2 = flowOf(
        "one", "two", "three"
    ).onEach { delay(200) }
    val startTime = System.currentTimeMillis()
    /*
    我们得到了完全不同的输出，其中，nums 或 strs 流中的每次发射都会打印一行：
     */
    nums2.combine(strings2) { a, b -> "$a is $b" }.collect {
        println("$it at ${System.currentTimeMillis() - startTime} ms from start")
    }
    println("----------------------------------")

    nums2.zip(strings2) { a, b -> "$a is $b" }.collect {
        println("$it at ${System.currentTimeMillis() - startTime} ms from start")
    }
}
