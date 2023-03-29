package com.zhou.kotlin.demo.kotlin.coroutines.flow

/**
 * 如果使用一些消耗 CPU 资源的阻塞代码计算数字（每次计算需要 100 毫秒）那么我们可以使用 Sequence 来表示数字：
 * 阻塞主线程
 */
fun main() {
    simpleSequence().forEach { value ->
        println("value is $value")
    }
}

fun simpleSequence() = sequence<Int> {
    for (i in 1..3) {
        Thread.sleep(1000)
        yield(i)
    }
}