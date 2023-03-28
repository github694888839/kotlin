package com.zhou.kotlin.demo.kotlin.coroutines

import kotlinx.coroutines.*

/**
 * Asynchronous timeout and resources
 */
var acquired = 0

class Resource {
    init {
        acquired++
    }

    fun close() {
        acquired--
    }
}

fun main() = runBlocking {
    repeat(100000) {
        val resource = withTimeout(60) {
            delay(50)
            Resource()
        }
        resource.close()
    }

    println(acquired)
}