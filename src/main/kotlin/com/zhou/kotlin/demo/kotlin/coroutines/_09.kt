package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

fun main()= runBlocking {
    repeat(1000){
        delay(1000)
        println("I'm sleep $it second.")
    }
    delay(1300)

}