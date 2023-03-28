package com.zhou.kotlin.demo.kotlin.coroutines.suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("result : ${one + two}")
    }

    println("Completed time is $time")

}

suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne")
    delay(1000)
    return 56
}

suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo")
    delay(1300)
    return 1
}