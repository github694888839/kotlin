package org.example.gson

import kotlin.jvm.JvmStatic

object ThreadDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = Thread({
            println("a is running")
            Thread.sleep(3000)
            println("a is stop")
        }, "a")
        val b = Thread({
            a.join()
            //a.interrupt()
            println("b is running")
            Thread.sleep(1000)
            println("b is stop")
        }, "b")
        a.start()
        b.start()
    }
}