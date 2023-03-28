package com.zhou.kotlin.demo

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.lang.Thread.sleep

fun main() {
    var value = 0
    val mutex = Mutex()
    repeat(10) {
        GlobalScope.launch(Dispatchers.IO) {
            mutex.withLock {
                repeat(10) {
                    value++
                    println(value)
                }
            }
        }
    }
    sleep(1000)
    println("value = $value")
}