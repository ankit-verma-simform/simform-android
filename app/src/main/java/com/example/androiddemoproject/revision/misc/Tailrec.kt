package com.example.androiddemoproject.revision.misc

import java.math.BigInteger

fun main() {
    println(fib(100000, BigInteger.ZERO, BigInteger.ONE))
    // println(fibWithoutTailRec(100000, BigInteger.ZERO, BigInteger.ONE))
}

// fibonacci series
tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) b
    else fib(n - 1, a + b, a)
}

fun fibWithoutTailRec(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) b
    else fib(n - 1, a + b, a)
}
