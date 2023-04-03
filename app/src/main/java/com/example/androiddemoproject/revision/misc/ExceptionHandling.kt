package com.example.androiddemoproject.revision.misc

fun main() {

    val numberInMessage = "One"
    val incrementedNumber = try {
        numberInMessage.toInt() + 1
    } catch (e: Exception) {
        1
    } finally {
        println(0)
        null
    }
    println(incrementedNumber)
}