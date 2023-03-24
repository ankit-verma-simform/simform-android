package com.example.androiddemoproject.kotlinbasics

import java.time.Duration

fun testFunction(vararg nums: Int, msg: String) {
    println(msg)
    nums.forEach { it }
}

open class A {
    open fun foo(i: Int = 10) { /*...*/
    }
}

class B : A() {
    override fun foo(i: Int) { /*...*/
    }  // No default value is allowed.
}

fun paramChecks(p1: Int, p2: Int = 2, vararg p3: Int, p4: Int = 4, p5: Int) {
    println("p1: $p1")
    println("p2: $p2")
    println("p3: ${p3.map { it }}")
    println("p4: $p4")
    println("p5: $p5")
}

val x = { n: Int -> n * n }

fun cube(n: Int) = n * n * n

fun main() {
    val sqx = x(40)
    val sqx2 = x(20)
    println(sqx)
    println(sqx2)

//    paramChecks(1, 2, p2=5) // error
//    paramChecks(1, 2, 3, 4) // error
//    paramChecks(1, 2, 3, 4) // error
    paramChecks(1, 2, 3, 9, p5 = 5) // valid

    fun foo(vararg strings: String) { /*...*/ }

    foo(strings = arrayOf("a", "b", "c"))

//    paramChecks(1, 2, 3, 4, p5 = 5) // valid
//    paramChecks(1, 2, p5 = 3, 4, p5 = 5) // error
    paramChecks(1, 2, p5 = 3, p3 = intArrayOf(1, 2, 3)) // valid

    infix fun Int.times(n: Int) = this * n
    println("3 x 4 + 1 = ${(3 times 4) + 1}")

    data class Point(val x: Int, val y: Int) {
        operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)
        operator fun minus(other: Point): Point = Point(x - other.x, y - other.y)
        operator fun times(other: Point): Point = Point(x * other.x, y * other.y)
    }

    val p1 = Point(1, 1)
    val p2 = Point(2, 2)
    println(p1 + p2)

    fun looper() {
        repeat(1000000) {}
    }

    calcTime { looper() }
    calcTime { looper() }
    calcTime { looper() }
}

inline fun calcTime(fn: () -> Unit) {
    val start = System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("fn took - ${end - start} ms")
}