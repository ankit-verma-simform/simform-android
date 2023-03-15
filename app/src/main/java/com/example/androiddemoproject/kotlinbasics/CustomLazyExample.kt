package com.example.androiddemoproject.kotlinbasics

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class CustomLazy<out T : Any>(private val initializeValue: () -> T) :
    ReadOnlyProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            value = initializeValue()
        }
        return value!!
    }
}

fun <T : Any> customLazy(initializeValue: () -> T) = CustomLazy(initializeValue)

class CustomLazyExample {
    val value by customLazy {
        println("My custom lazy initialized!")
        2612
    }

    val anotherValue by lazy {
        println("initialized standard lazy")
        38
    }

    init {
        println("Custom Example class created!")
    }
}

fun main() {
    val customLazyExample = CustomLazyExample()
    println("Doing something else in the meanwhile...")
    println("Getting value", customLazyExample.value)
}