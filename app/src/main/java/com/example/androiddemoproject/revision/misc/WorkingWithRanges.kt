package com.example.androiddemoproject.revision.misc


fun main() {
    val myRange = 1.2..2.0
    println("Is 1.7 in range(1.2, 2.0)? ${1.7 in myRange}")

    for (i in 5 downTo 1 step 2) {
        println(i)
    }

    // looping over double range
    for (i in 11.1..3.1 step 1.0) {
        println(i)
    }
}

infix fun ClosedFloatingPointRange<Double>.step(step: Double)
        : Iterable<Double> {
    require(start.isFinite())
    require(endInclusive.isFinite())
    require(step > 0.0) { "Step must be positive " }
    if (endInclusive >= start) return emptyList()

    val sequence = generateSequence(start) { previous ->
        if (previous == Double.POSITIVE_INFINITY) return@generateSequence null
        val next = previous + step
        if (next > endInclusive) null else next
    }

    return sequence.asIterable()
}

