package com.example.androiddemoproject.kotlinbasics

enum class Colors(private val code: Int) {
    RED(0xFF00FF),
    BLUE(0x0000FF),
    GREEN(0x00FF00);
    fun getColor() = code
}

fun main() {
    val red = Colors.RED
    val anotherRed = Colors.RED
    println("Same instance", red.hashCode(), anotherRed.hashCode())
}