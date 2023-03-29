package com.zhou.kotlin.demo.kotlin.coroutines.coroutinecontext

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * 调度器与线程
 *
 * 当调用 launch { …… } 时不传参数，它从启动了它的 CoroutineScope 中承袭了上下文（以及调度器）。在这个案例中，它从 main 线程中的 runBlocking 主协程承袭了上下文。

Dispatchers.Unconfined 是一个特殊的调度器且似乎也运行在 main 线程中，但实际上， 它是一种不同的机制，这会在后文中讲到。

当协程在 GlobalScope 中启动时，使用的是由 Dispatchers.Default 代表的默认调度器。 默认调度器使用共享的后台线程池。 所以 launch(Dispatchers.Default) { …… } 与 GlobalScope.launch { …… } 使用相同的调度器。

newSingleThreadContext 为协程的运行启动了一个线程。 一个专用的线程是一种非常昂贵的资源。 在真实的应用程序中两者都必须被释放，当不再需要的时候，使用 close 函数，或存储在一个顶层变量中使它在整个应用程序中被重用。
 */
fun main() = runBlocking<Unit> {
    launch {//主线程里面
        println("I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {//不受限的，将工作在主线程
        println("Unconfined: I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {//将会获取默认调度器
        println("Default: I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("new Thread")) {//将使他获得一个新的线程
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}