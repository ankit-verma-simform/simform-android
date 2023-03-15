package com.example.androiddemoproject.kotlinbasics

fun Int.cube() = this * this * this
fun String.countWords() = this.split(" ").size
fun String.capitalize() = first().uppercase() + subSequence(startIndex = 1, endIndex = length)

fun main() {
    println("this is some string with many words".countWords())
    println("this is summer season".capitalize())
}