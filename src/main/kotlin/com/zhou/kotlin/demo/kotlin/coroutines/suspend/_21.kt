package com.zhou.kotlin.demo.kotlin.coroutines.suspend

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
async 风格的函数 这中风格不推荐
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomeThingOneAsync()
        val two = doSomeThingTwoAsync()
        one.start()
        two.start()
        println("result : ${one.await() + two.await()}")
    }

    println("Completed time is $time")

}

fun doSomeThingOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

fun doSomeThingTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}