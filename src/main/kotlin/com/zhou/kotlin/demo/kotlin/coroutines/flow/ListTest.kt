package com.zhou.kotlin.demo.kotlin.coroutines.flow

fun main() {
    simpleList().forEach { value ->
        println("value is $value")
    }
}

fun simpleList() = mutableListOf(1, 2, 3)