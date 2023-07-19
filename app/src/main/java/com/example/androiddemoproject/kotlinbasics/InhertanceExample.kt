package com.example.androiddemoproject.kotlinbasics

// classes are by default final and can't be inherited
open class House(
    val address: String,
    val name: String? = null
) { // use open keyword to allow inheritance
    init {
        println("House initialized")
    }
}

class Castle(address: String, name: String? = null) : House(address, name) {
    init {
        println("Castle initialized")
    }
}

abstract class Shape {
    abstract val vertexCount: Int
    fun draw() {
    }
}

class Rectangle(val height: Int, val width: Int) : Shape() {
    override val vertexCount: Int = 4
}

class Square : Shape() {
    override val vertexCount: Int = 4
}

// overriding rules

interface SuperA {
    fun implementThis() { // by default open
        println("from super a")
    }
}

interface SuperB {
    fun implementThis() {
        println("from super b")
    }
}

open class MultipleImpl : SuperA, SuperB {
    override fun implementThis() {
        super<SuperA>.implementThis()
        super<SuperB>.implementThis()
        println("from multiple impl")
    }
}

fun main() {
    val myCastle = Castle(name = "Snow Castle", address = "North Pole")
    val multipleImpl = object : MultipleImpl() {}
    multipleImpl.implementThis()
}