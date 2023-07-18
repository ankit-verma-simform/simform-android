package com.example.androiddemoproject.kotlinbasics

class SomeClass(val a: Int, val b: Int? = a)

fun main() {
    var notNullNumber = 1234 // can never be null - stored as primitive
    lateinit var nullableNumber: String
    println(nullableNumber)

//     nullableNumber = 678

    /*
        Decompiled Java:
        int notNullNumber = true;
        Integer nullableNumber = null;
        nullableNumber = 678;
    */


    val sc: SomeClass? = SomeClass(a = 13)
    sc?.run { // ensured not null
        println(b)
        val sum = with(b) {
            this?.plus(a) // safe call
        }
        println(sum)
    }

    val nums = mutableListOf(1, 2, 3, 4, null, 6, 7, 8) // nullable collection
    var sum = 0
    for (num in nums) {
        sum += num ?: 0 // elvis
    }
    println("Sum is $sum")

    lateinit var ensuredNotNullString: String // will be null
//    println(ensuredNotNullString.length) // throws NPE as access before initializing
    ensuredNotNullString = "some new string"

    println("Ensured string: $ensuredNotNullString")
}