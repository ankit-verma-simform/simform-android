package com.example.androiddemoproject.kotlinbasics

interface Flyable {
    fun fly()
    val noOfWings: Int
    fun dive() {
        println("Diving from sky towards ground")
    }
}

class Bird : Flyable {
    override fun fly() {
        println("Fly using flapping wings")
    }

    override var noOfWings: Int = 2

//    override val noOfWings: Int // var properties can't be override as val properties
//        get() = 2

}

class FlyingCar(override val noOfWings: Int = 2) : Flyable {
    override fun fly() {
        println("Fly using the wings and jet engine")
    }
}

fun interface NumberCheck {
    fun compute(num: Int): Int
}

open class X
interface  Y
class Z: X(), Y

fun main() {
    val isEven = NumberCheck { it % 2 }
    val cube = NumberCheck { it * it *it }
    val square = { num: Int -> num * num }
}