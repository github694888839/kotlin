package com.zhou.kotlin.demo.kotlin.coroutines.canceltimeout

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(1000) {
            println("job: I'm sleeping in $it")
            delay(500)
        }
    }
    delay(1000)//delay 1s
    println("main: I'm tired of waiting...")
    /*
    一旦 main 函数调用了 job.cancel，我们在其它的协程中就看不到任何输出，因为它被取消了。
     这里也有一个可以使 Job 挂起的函数 cancelAndJoin 它合并了对 cancel 以及 join 的调用。
     */
    job.cancel()
    job.join()
    println("main: Now i can quit.")

}