package com.example.androiddemoproject.revision.misc

fun main() {
    val brownie = Cat("brownie")
    println(brownie.fullName)
}

class SomeClass private constructor()

interface Animal {
    val name: String
    val type: String
    val fullName: String
        get() = "$name is a $type"

    private val base: String
        get() = "Animal"
}

class Cat(override val name: String) : Animal {
    override val type = "Cat"
    override val fullName: String
        get() = "$name is a Cat that says Meow!"
}

class Dog(name: String) : Animal {
    override val name: String
    override val type = "Dog"

    init {
        this.name = name
    }
}

// multiple default methods with same signature of interfaces must be
// overridden by child class

interface A {
    fun foo() = "foo A"

    companion object {
        const val intA: Int = 100
    }
}

interface B {
    fun foo() = "foo B"
    fun bar() = "bar B"

    companion object {
        fun square() = "square it"
    }
}

class C : A, B {
    override fun foo(): String {
        return super<B>.foo() + super<A>.foo()
    }
}

// abstract class
abstract class Vehicle {
    abstract val name: String
    open fun start() = println("Starts engine")
}

class Bmw(override val name: String) : Vehicle() {
    override fun start() = println("Starts engine of Bmw")
}