package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
缓冲
从收集流所花费的时间来看，将流的不同部分运行在不同的协程中将会很有帮助，特别是当涉及到长时间运行的异步操作时。例如，考虑一种情况，
一个 simple 流的发射很慢，它每花费 100 毫秒才产生一个元素；而收集器也非常慢， 需要花费 300 毫秒来处理元素。
让我们看看从该流收集三个数字要花费多长时间：
 */
fun simpleCollectTime() = flow {
    for (i in 1..5) {
        delay(100)//假装我们异步等待了100ms
        emit(i)//发射下一个值
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        simpleCollectTime().collect {
            delay(300)//假装我们需要300ms处理
            println("value is $it")
        }
    }
    println("collect time is $time")
/*
我们可以在流上使用 buffer 操作符来并发运行这个 simple 流中发射元素的代码以及收集的代码， 而不是顺序运行它们：
它产生了相同的数字，只是更快了，由于我们高效地创建了处理流水线， 仅仅需要等待第一个数字产生的 100 毫秒以及处理每个数字各需花费的 300 毫秒。
这种方式大约花费了 1000 毫秒来运行：
 */
    val bufferTime = measureTimeMillis {
        simpleCollectTime()
            .buffer()
            .collect {
                delay(300)//假装我们需要300ms处理
                println("value is $it")
            }
    }
    println("collect buffer time is $bufferTime")
}
