package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*流是冷的
Flow 是一种类似于序列的冷流 — 这段 flow 构建器中的代码直到流被收集的时候才运行。这在以下的示例中非常明显：


这是返回一个流的 simple 函数没有标记 suspend 修饰符的主要原因。 通过它自己，simple() 调用会尽快返回且不会进行任何等待。该流在每次收集的时候启动，
这就是为什么当我们再次调用 collect 时我们会看到“Flow started”。*/

fun main() = runBlocking {
    println("call simple cold function")
    val flow = simpleFlowCold()
    println("collect")
    flow.collect { value -> println("value is $value") }
    println("collect again")
    flow.collect { value -> println("value is $value") }
}

fun simpleFlowCold() = flow<Int> {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}
