package com.example.androiddemoproject.kotlinbasics

//data class create equate method using default constructor values only
data class DataClass(val eqParam: String) {
    var notEqParam: Int = 0
    override fun toString(): String =
        "DataClass(eqParam=$eqParam, notEqParam=$notEqParam)"
}

// inheritance possible
open class SuperClass
data class SubDataClass(val data: String) : SuperClass()

// open data class DataParentClass(val data: Int) // won't compile
// can't inherit from data class

fun main() {
    val x = DataClass(eqParam = "Eq")
    x.notEqParam = 10
    val y = DataClass(eqParam = "Eq")
    y.notEqParam = 30
    println("Is $x == $y? ", x == y)

    val pair = 1 to 2
    val triple = Triple(3, 8, 7)
    println(triple, pair)

    val parcel = Parcel("ksdj", null)
    parcel.age = 11
    parcel.age?.let {
        println(it)
    }
}

data class Parcel(val value: String, var age: Int? = 0)