package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..3).asFlow().map { value ->
        performRequest(value)
    }.collect { value ->
        println(value)
    }
    println("-------------------------------")
    (1..3).asFlow().transform { value ->
        emit("Marking request $value")
        emit(performRequest(value))
    }.collect { value ->
        println(value)
    }
}

suspend fun performRequest(request: Int): String {
    delay(1000)
    return "Perform Request: $request"
}