package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * 末端流操作符
 * 末端操作符是在流上用于启动流收集的挂起函数。 collect 是最基础的末端操作符，但是还有另外一些更方便使用的末端操作符：

转化为各种集合，例如 toList 与 toSet。
获取第一个（first）值与确保流发射单个（single）值的操作符。
使用 reduce 与 fold 将流规约到单个值。
 */
fun main() = runBlocking {
    val sum = (1..5).asFlow().map {
        it * it
    }.reduce { a, b -> a + b }
    println(sum)
}