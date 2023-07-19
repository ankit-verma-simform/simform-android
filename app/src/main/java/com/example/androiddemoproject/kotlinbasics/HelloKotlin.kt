package com.example.androiddemoproject.kotlinbasics

/**
 * Kotlin Features:
 *  - Less code combined with greater readability.
 *  - Mature language and environment
 *  - Kotlin support in Android Jetpack and other libraries.
 *  - Interoperability with Java
 *  - Support for multiplatform development
 *  - Code safety.
 *  - Easy learning
 *  - Big community
 *
 *  - Have support for Java libraries and collections frameworks
 *  - Developed with focus on productivity
 *  - can help greatly with server side dev too
 *  - language supports both functional as well as oop
 *
 *  #1st choice for developing Android Apps
 */

fun main() {
    println("Hello, Kotlin")

    // kotlin interoperable with java
    val map = java.util.HashMap<Int, String>() // using java hashmap in kotlin
    map[1] = "Mercury"
    map[2] = "Venus"
    map[3] = "Earth"
    map.forEach { (idx, planet) -> println("$planet is at position - $idx") } // kotlin style

    // Kotlin Numeric Types Examples

    // val myByte: Byte = 128 // shows compile time error as 128 won't fit in byte
    val myShort: Short = 32767 // max value stored in short

    val myInt: Int = 2_000_000_000 // 2 billion
    val myLong = 3000L    // The suffix 'L' is used to specify a long value

    val myFloat = 123.45f   // The suffix 'f' or 'F' represents a Float
    val myDouble = 321.05

    val hundredThousand = 100_000
    val oneMillion = 1_000_000

    val aTrueValue = true

    val letterChar = 'K'
    val digitChar = '1'

    var basicKotlin = "Basic Kotlin"

    // arrays
    val numbers = arrayOf(5, 4, 3, 2, 1, 0)
    numbers.sort()
    print("Array sorted: ")
    numbers.forEach { print(it) }

    val myStringArray = Array(8) { "$it" }
    print("\nArray: ")
    myStringArray.forEach { print("$it, ") }

    // control flow
    val notRaining = true
    val plan = if (notRaining) "go for walk" else "go to sleep"

    var k: String? = null
    k = "some valid string"
    if (k != null) {
        println(k)
    }

    // when
    val age = 17.6
    when {
        age < 18.0 -> println("You can't vote")
        else -> println("You can vote")
    }

    // for in
    val fruits = listOf("mango", "apple", "banana", "grapes")
    for (fruit in fruits) {
        print(fruit.capitalize())
    }

    // using elvis operator
    val favBooks: List<String?> = mutableListOf("Think & Grow Rich", null, "Atomic Habits")
    favBooks.forEach { println(it ?: "Missing name") }

    class Shape(sides: Int) {
        var sides: Int
        // -ve, 1, 2
        init {
            this.sides = if (sides > 0) sides else 0
        }
    }

    // using safe call
    val shapes = listOf(
        Shape(sides = 4),
        Shape(sides = -3),
        null
    )
    print("Shapes: ")
    shapes.forEach { println("Shape has ${it?.sides ?: "-"} sides") }

    print("Even numbers: ")
    for (even in 2..10 step 2) {
        print("$even, ")
    }

}