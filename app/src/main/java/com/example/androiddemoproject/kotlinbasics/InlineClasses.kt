package com.example.androiddemoproject.kotlinbasics

interface DoubleConverter {
    fun toDouble(): Double
}

// uncomment to make it inline and decompile to java to see the optimizations
@JvmInline
value
class Height(private val value: Int): DoubleConverter {
    override fun toDouble() = value.toDouble()
}

// uncomment to make it inline and decompile to java to see the optimizations
@JvmInline
value
class Width(val value: Int)

class Parallelogram(val height: Height, val width: Width)

fun main() {
    val parallelogram = Parallelogram(Height(13), Width(15))

    /*  Decompiled java code without inline ----

        public static final void main() {
            new Parallelogram(new Height(13), new Width(15));
        }
    */

    /*  Decompiled java code with inline ----

        public static final void main() {
            new Parallelogram(Height.constructor-impl(13), Width.constructor-impl(15), (DefaultConstructorMarker)null);
        }
    */

    // using typealias
    greetMe("Hi there")
    // using inline class
    greetMe(GreetWrapper("Hi there"))
}

typealias GreetMessage = String
@JvmInline
value class GreetWrapper(private val message: String)

fun greetMe(message: GreetMessage) {
    println(message)
}

//fun greetMe(message: String) { // won't let it compile as GreetMessage is already defined
//    println(message)
//}

fun greetMe(message: GreetWrapper) {
    println(message)
}