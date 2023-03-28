package com.zhou.kotlin.demo.kotlin.coroutines.canceltimeout

import kotlinx.coroutines.*

/**
 * Asynchronous timeout and resources
 */

fun main() = runBlocking {
    repeat(100000) {
        launch {
            var resource: Resource? = null
            try {
                withTimeout(60) {
                    delay(50)
                    resource = Resource()
                }
            } finally {
                resource?.close()
            }
        }
    }

    println(acquired)
}