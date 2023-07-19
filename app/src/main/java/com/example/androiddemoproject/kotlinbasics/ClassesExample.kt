package com.example.androiddemoproject.kotlinbasics

data class Person(val firstName: String, val lastName: String) {

    private var favNumber: Int? = null

    companion object {
        fun sleep() {

        }
    }

    init {
        println("first init called")
    }

    constructor() : this(firstName = "Random Name", lastName = "Random Surname") {
        println("constructor called!")
    }

    init {
        println("second init called")
    }

    fun getFavNumber() = favNumber
    fun setFavNumber(no: Int) { favNumber = no }
}

class CantCreateInstanceFromMe private constructor()

abstract class Vehicle {
    var wheels: Int = 4
    abstract fun drive()
}

class BMW : Vehicle() {
    override fun drive() {
        println("Driving ${this.javaClass.simpleName}")
    }
}

fun main() {
    val person = Person()
    val x = null
    Person.sleep()

    val person2 = Person(firstName = "Ankit", lastName = "Verma")

//    CantCreateInstanceFromMe() // compile time error!
    with(person2) {
        setFavNumber(12)
        println(getFavNumber())
    }

    val bmw = BMW()
    bmw.drive()
    println(bmw.wheels)
}