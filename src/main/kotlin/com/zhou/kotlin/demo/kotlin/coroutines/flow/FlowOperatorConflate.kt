package com.zhou.kotlin.demo.kotlin.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
合并
当流代表部分操作结果或操作状态更新时，可能没有必要处理每个值，而是只处理最新的那个。在本示例中，当收集器处理它们太慢的时候，
conflate 操作符可以用于跳过中间值。构建前面的示例：
 */

fun simpleFlowConflate() = flow<Int> {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}


fun main() = runBlocking {
    /*
我们看到，虽然第一个数字仍在处理中，但第二个和第三个数字已经产生，因此第二个是 conflated ，只有最新的（第三个）被交付给收集器：
 */
    var time = measureTimeMillis {
        simpleFlowConflate()
            .conflate()//合并发射项，不对每一个进行处理
            .collect { value ->
                delay(300)//假装我们需要300ms来处理
                println(value)
            }
    }
    println(time)
/*
处理最新值
当发射器和收集器都很慢的时候，合并是加快处理速度的一种方式。它通过删除发射值来实现。 另一种方式是取消缓慢的收集器，并在每次发射新值的时候重新启动它。
有一组与 xxx 操作符执行相同基本逻辑的 xxxLatest 操作符，但是在新值产生的时候取消执行其块中的代码。让我们在先前的示例中尝试更换 conflate 为 collectLatest：
 */
    time = measureTimeMillis {
        simpleFlowConflate()
            .collectLatest {//取消并重新发射最后一个值
                println("collect $it")
                delay(300)
                println("Done $it")
            }
    }
    /*
    由于 collectLatest 的函数体需要花费 300 毫秒，但是新值每 100 秒发射一次，我们看到该代码块对每个值运行，但是只收集最后一个值：
     */
    println(time)
}