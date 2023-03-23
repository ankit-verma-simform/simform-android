package com.example.androiddemoproject.kotlinbasics

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringFormatter(initialString: String) : ReadWriteProperty<Any?, String> {
    private var formattedString: String = ""
        set(value) {
            field = value.capitalize()
        }

    init {
        formattedString = initialString
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return formattedString
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        formattedString = value
    }
}

class Employee(firstName: String, lastName: String, role: String) {
    var firstName: String by StringFormatter(firstName)
    var lastName: String by StringFormatter(lastName)
    var role: String by StringFormatter(role)

    override fun toString(): String = "Employee"
    fun info() = "Employee - $firstName $lastName ($role)"
}

class LazyExample {
    val lazyMessage: String by lazy {
        println("Initialized")
        "my lazy message"
    }
}

class Counter {
    var value: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("$oldValue changed to $newValue")
    }
        private set

    fun increment() = value++
    fun decrement() = value--
}

class DelegatePropertyExample(var delegateToThis: Int) {
    @Deprecated(":( don't use this", ReplaceWith(""))
    var value: Int = 0
    var newValue: Int by this::delegateToThis
}

fun main() {
    val nakul = Employee("nakul", "sharma", "iot engineer")
    val krish = nakul
    println(krish.info()) // He remembers he forget to update the name
    krish.firstName = "krish" // updates name
    println(krish.info())

    val lazyExample = LazyExample()
    println("Lazy message is", lazyExample.lazyMessage)
    println("Lazy message (cached) is", lazyExample.lazyMessage)

    val counter = Counter()
    counter.increment()
    counter.increment()
    counter.decrement()


}

/* TODO: Ask Questions:
    -   how can I pass initial value to delegate such that it is also validated with conditions first
        then set the property
    -   reduce redeclaration of parameters into properties directly in constructor with delegate
 */