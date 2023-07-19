package com.example.androiddemoproject.revision.koans

import java.util.*

fun <T, C : MutableCollection<T>> Collection<out T>.partitionTo(
    c1: C,
    c2: C,
    condition: (T) -> Boolean
): Pair<C, C> {
    forEach { if (condition(it)) c1.add(it) else c2.add(it) }
    return Pair(c1, c2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}

fun main() {
    partitionLettersAndOtherSymbols()
    partitionWordsAndLines()
}