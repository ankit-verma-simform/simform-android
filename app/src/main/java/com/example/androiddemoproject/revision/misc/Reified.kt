package com.example.androiddemoproject.revision.misc

import kotlin.reflect.KClass

fun main() {
    printClassName(cls = Int::class)
    printClassName<Int>()
    printClassName<String>()
    val intMsg: Int = message(89)
    println(intMsg)
    val strMsg: String = message(89)
    println(strMsg)
}

//fun <T> printClassName() {
//    println(T::class.simpleName)
//} // won't compile!

fun <T : Any> printClassName(cls: KClass<T>) {
    println(cls.simpleName)
}

inline fun <reified T> printClassName() {
    println(T::class.simpleName)
}

inline fun <reified T> message(marks: Int): T {
    return when (T::class) {
        Int::class -> marks as T
        String::class -> "You scored $marks!" as T
        else -> throw IllegalStateException("Can only pass String or Int")
    }
}