package com.zhou.kotlin.demo.kotlin.coroutines.coroutinecontext

import kotlinx.coroutines.*

/**
 * 上下文中的作业(Job)
 *
 */
fun main() = runBlocking<Unit> {
    println("job: ${coroutineContext[Job]}")
}