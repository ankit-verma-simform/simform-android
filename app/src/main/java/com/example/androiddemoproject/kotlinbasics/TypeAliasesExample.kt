package com.example.androiddemoproject.kotlinbasics

typealias AudioFrequency = UByte
typealias ComputeOnNumber = (Int) -> Int

fun computeFactory(times: Int, fn: ComputeOnNumber): ComputeOnNumber {
    return fun (num: Int): Int {
        return fn(num) * times
    }
}

fun main() {
    val minAudioFrequency = AudioFrequency.MIN_VALUE
    val maxAudioFrequency = AudioFrequency.MAX_VALUE
    println(minAudioFrequency, maxAudioFrequency)

    val fn = computeFactory(3) { it * 2 }
    println(fn(5))
}