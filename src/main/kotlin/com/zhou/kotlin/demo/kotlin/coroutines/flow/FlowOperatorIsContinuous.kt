package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * 流是连续的
流的每次单独收集都是按顺序执行的，除非进行特殊操作的操作符使用多个流。该收集过程直接在协程中运行，该协程调用末端操作符。
默认情况下不启动新协程。 从上游到下游每个过渡操作符都会处理每个发射出的值然后再交给末端操作符。
 */
fun main() = runBlocking {
    (1..5).asFlow().filter {
        println("Filter $it")
        it % 2 == 0
    }.map {
        println("Map $it")
        "String $it"
    }.collect {
        println("collect $it")
        println(it)
    }
}