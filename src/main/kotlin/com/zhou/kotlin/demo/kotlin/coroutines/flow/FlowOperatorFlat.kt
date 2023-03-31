package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


/*
展平流
 */

fun requestFlow(i: Int) = flow<String> {
    emit("$i First")
    delay(500)
    emit("$i Second")
}

fun main(): Unit = runBlocking {
    val startTime = System.currentTimeMillis() // 记录开始时间
    /*
    连接模式由 flatMapConcat 与 flattenConcat 操作符实现。它们是相应序列操作符最相近的类似物。它们在等待内部流完成之前开始收集下一个值，如下面的示例所示：
     */
    (1..3).asFlow().onEach { delay(100) }
        .flatMapConcat { requestFlow(it) }
        .collect {
            println("$it at ${System.currentTimeMillis() - startTime} ms from start")
        }
    /*
    另一种展平模式是并发收集所有传入的流，并将它们的值合并到一个单独的流，以便尽快的发射值。 它由 flatMapMerge 与 flattenMerge 操作符实现。
    他们都接收可选的用于限制并发收集的流的个数的 concurrency 参数（默认情况下，它等于 DEFAULT_CONCURRENCY）。
     */
    println("-----------------------------")
    (1..3).asFlow().onEach { delay(100) }
        .flatMapMerge { requestFlow(it) }
        .collect {
            println("$it at ${System.currentTimeMillis() - startTime} ms from start")
        }
    /*
    与 collectLatest 操作符类似（在"处理最新值" 小节中已经讨论过），也有相对应的“最新”展平模式，在发出新流后立即取消先前流的收集。
    这由 flatMapLatest 操作符来实现。
     */
    println("-----------------------------")
    (1..3).asFlow().onEach { delay(100) }
        .flatMapLatest { requestFlow(it) }
        .collect {
            println("$it at ${System.currentTimeMillis() - startTime} ms from start")
        }
}