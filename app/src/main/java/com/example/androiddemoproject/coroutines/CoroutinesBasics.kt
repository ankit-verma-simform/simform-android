package com.example.androiddemoproject.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Calendar
import kotlin.system.measureTimeMillis

private suspend fun getValue(): Double {
    println("Enters @${Thread.currentThread()}: ${Calendar.getInstance().time}")
    delay(2000)
    println("Exits @${Thread.currentThread()}: ${Calendar.getInstance().time}")
    return Math.random()
}

fun main() {
    // runBlocking { globalScopeConcept() }
    println(measureTimeMillis { sequentialExecution() })
    println(measureTimeMillis { parallelExecution() })
}

private fun globalScopeConcept() {
    GlobalScope.launch {
        println("Hello from coroutine on Global Scope")
    }
}

private fun sequentialExecution() = runBlocking {
    val v1 = getValue()
    val v2 = getValue()
    println("Sum $v1 + $v2 = ${v1 + v2}")
}

private fun parallelExecution() = runBlocking {
    val v1 = async { getValue() }
    val v2 = async { getValue() }
    println("Sum $v1 + $v2 = ${v1.await() + v2.await()}")
}