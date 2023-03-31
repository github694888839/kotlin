package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
流异常
当运算符中的发射器或代码抛出异常时，流收集可以带有异常的完成。 有几种处理异常的方法。

try/catch

 */

fun simpleFlowException() = flow<Int> {
    for (i in 1..3) {
        delay(100)
        emit(i)//发射下一个值
    }
}

fun main() = runBlocking {
    try {
        simpleFlowException().collect {

        }
    } catch (e: Exception) {
    }
}
