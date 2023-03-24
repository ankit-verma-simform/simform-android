package com.example.androiddemoproject.kotlinbasics

fun main() {
    val num1: Int = 3
    val num2: Int? = 3
    println(num1.hashCode(), num2.hashCode())
    println("Structural equality: ${num1 == num2}")
    println("Referential equality: ${num1 === num2}")

    val str1: String = "some string"
    val str2: String? = "some string"
    println(str1.hashCode(), str2.hashCode())
    println("Structural equality: ${str1 == str2}")
    println("Referential equality: ${str1 === str2}")

    data class Dummy(private val value: Int = 12)
    val dummy1: Dummy = Dummy()
    val dummy2: Dummy? = Dummy()
    println(dummy1.hashCode(), dummy2.hashCode())
    println("Structural equality: ${dummy1 == dummy2}")
    println("Referential equality: ${dummy1 === dummy2}")

    var copyDummy1 = dummy1
    println(dummy1.hashCode(), copyDummy1.hashCode())
    println("Structural equality: ${dummy1 == copyDummy1}")
    println("Referential equality: ${dummy1 === copyDummy1}")

    val decimal1 = 1.11234567890112345678901123456789011234567890
    val decimal2: Double? = 1.11234567890112340000000000000000
    println(decimal1.hashCode(), decimal2.hashCode())
    println("Structural equality: ${decimal1 == decimal2}") // true
    println("Referential equality: ${decimal1 === decimal2}") // true
    // checks upto 15 decimal places!

    val arr1 = arrayOf(1,2,3,4)
    val arr2 = arrayOf(1,2,3,4)
    println(arr1.hashCode(), arr2.hashCode())
    println("Structural equality: ${arr1 == arr2}") // false
    println("Referential equality: ${arr1 === arr2}") // false
}