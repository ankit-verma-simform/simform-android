package com.example.androiddemoproject.coroutines

private var counter = 0

fun main() {
    // startOneThread()
    // start10Threads()
    testRaceCondition()
}

private  fun startOneThread() {
    Thread {
        Thread.sleep(3000)
        println("Hello from ${Thread.currentThread()}")
    }.start()
}

// Threads execute in random unpredictable order
private fun start10Threads() {
    for (i in 1..10) {
        Thread {
            println("Entering @${Thread.currentThread()}")
            Thread.sleep(1000)
            println("Exiting @${Thread.currentThread()}")
        }.start()
    }
}

// multiple threads modifying same variable can cause race condition
private fun testRaceCondition() {
    println("Counter @start $counter")
    repeat(10) {
        Thread {
            Thread.sleep((1000L..5000L).random())
            counter++
            println("@Thread $it - Counter - $counter")
        }.start()
    }
    println("Counter @end $counter")
}