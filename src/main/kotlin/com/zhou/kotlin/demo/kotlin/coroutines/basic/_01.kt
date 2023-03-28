package com.zhou.kotlin.demo.kotlin.coroutines.basic

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main(){
    GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    println("hello")
    Thread.sleep(2000L)
}