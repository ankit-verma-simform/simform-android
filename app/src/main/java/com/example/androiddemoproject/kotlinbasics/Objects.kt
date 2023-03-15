package com.example.androiddemoproject.kotlinbasics

class WrapperClass {
    var title: String = "wrapper class"

    init {
        println("wrapper class initialized")
    }

    companion object Companion {
        init {
            println("companion object initialized with class instance")
        }
        const val z = 100
        fun xyz() = "Some method xyz"

        // can't access props / methods of companion class
    }

    object Sample {
        init {
            println("sample object initialized lazily as it is object declaration")
        }
        const val x = 10
        fun foo() = xyz() // objects can access companion object's method + props
    }

    object Sample2 {
        fun bar() = xyz()
        fun returnZ() = z
    }

    val obj1 = object {
        init {
            title = "new title" // can access surrounding scope
            println("Accessing sample", Sample)
            println("Value of x is", Sample.x)
            println("obj1 instantly initialized as it is object expression")
        }
    }
}

fun main() {
    val wc = WrapperClass()
    println(WrapperClass.Sample.x)
    println(WrapperClass.xyz())
}