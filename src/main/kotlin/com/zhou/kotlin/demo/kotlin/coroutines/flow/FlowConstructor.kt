package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

/**
 * flow的构造方法，flow，flowOf， asFlow
 */
fun simpleFlowConstructor() = flow<Int> {
    for (i in 1..3) {
        emit(i)
    }
}

fun simpleFLowConstructor2() = (1..3).asFlow()

fun simpleFLowConstructor3() = flowOf(1..3)