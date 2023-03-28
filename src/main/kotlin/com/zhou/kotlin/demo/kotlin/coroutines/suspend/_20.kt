package com.zhou.kotlin.demo.kotlin.coroutines.suspend

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 惰性启动的 async
可选的，async 可以通过将 start 参数设置为 CoroutineStart.LAZY 而变为惰性的。
在这个模式下，只有结果通过 await 获取的时候协程才会启动，或者在 Job 的 start 函数调用的时候。运行下面的示例：
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        one.start()
        two.start()
        println("result : ${one.await() + two.await()}")
    }

    println("Completed time is $time")

}