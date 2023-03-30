package com.example.androiddemoproject.revision.koans

fun <K, V> buildMutableMap(build: MutableMap<K, V>.() -> Unit): MutableMap<K, V> {
    val builder = mutableMapOf<K, V>()
    builder.build()
    return builder
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun main() {
    val map = usage()
    println(map)
}

fun test() {
    mutableMapOf<Int, String>().apply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}