package com.example.androiddemoproject.kotlinbasics

class OuterClass {
    val imOuterConstant = "some constant string"
    var mOuterVariable = "I can change"
        private set

    inner class InnerClass(changeParentVariable: String) { // can't access parent's members unless mark it as inner
        val imInnerConstant = "$imOuterConstant joined with inner constant"

        init {
            mOuterVariable = changeParentVariable
        }

        fun changeOuterVariable(newString: String) {
            mOuterVariable = newString
        }
    }
}

class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

open class Star {
    open var name: String = ""
}

fun main() {
    val k = Outer.Nested()
    val obj = OuterClass()
    println(obj.mOuterVariable)

    val innerObj = obj.InnerClass(changeParentVariable = "I am changed")
    // can't access outer class members from inner class's instance
//    println(innerObj.mOuterVariable) // compile time error
    println(obj.mOuterVariable) // changed

//    obj.mOuterVariable = "new" // can't set variable from outside

    val sun = object: Star() {
        override var name: String = "Sun"
        override fun toString(): String = name
    }
    println(sun)
}