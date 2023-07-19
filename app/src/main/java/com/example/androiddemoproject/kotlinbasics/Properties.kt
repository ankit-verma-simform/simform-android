package com.example.androiddemoproject.kotlinbasics

const val FILE = "Properties"

fun main() {
    class Math {
        var number: Int = 0
            set(value) {
                if (value > 0) {
                    field = value
                }
            }
        val square get() = number * number
    }

    val m = Math()
    m.number = 5
//    m.square = 9
    println(m.square)
}