package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        
    }
    repeat(1000){
        delay(1000)
        println(".")
    }

}