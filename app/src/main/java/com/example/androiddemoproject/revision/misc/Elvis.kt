package com.example.androiddemoproject.revision.misc

fun main() {
    val a = true
    // return if a is null
    fun foo() {
        a ?: return
        println("foo $a")
    }
    foo()
}