package com.example.androiddemoproject.revision.koans

/*
Add a custom getter to make the val lazy really lazy. It should be initialized by invoking
initializer() during the first access.

You can add any additional properties as you need.
Do not use delegated properties!
 */

class LazyProperty(val initializer: () -> Int) {
    init {
        println("LazyProperty object initialized")
    }

    val lazy: Int
        get() {
            if (_lazy == null) {
                _lazy = initializer()
                println("Initialized lazy with $_lazy")
            }
            return _lazy!!
        }

    private var _lazy: Int? = null
}

fun main() {
    val lazyProp = LazyProperty {
        10
    }

    println(lazyProp.lazy)
}