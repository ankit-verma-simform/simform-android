package com.example.androiddemoproject.kotlinbasics

import java.lang.Integer.parseInt

fun println(
    vararg messages: Any?,
    separator: String = " ",
    terminator: String = "\n"
) {
    messages.forEach {
        print(it)
        print(separator)
    }
    print(terminator)
}

fun main() {

    val byte: Byte = 124
    val byte2: Byte = 124
    val aShort: Short = 32000
    val anInt = 2000000000
    val aLong = 9_000_000_000_000_000

    val explicitLong = 10L
    val implicitLong = 100
    val sum = implicitLong + explicitLong
    println(sum)

    val aDouble = 3.14159
    val someFloat = 2.718F

    val binaryTwelve = 0b00001100
    val hexRedCode = 0xFF_00_00
    // kotlin don't support octal literals!

    var aString = "this is a string"
    var anotherString = "this is a string"

    data class Cat(val name: String)

    val aNullableInt: Int? = null
    val anotherNullableInt: Int? = 10

    val aBoolean = true
    val anotherBoolean = true

    // hashCodes are same as literal values for int/long types!
    println(byte.hashCode())
    println(byte2.hashCode())
    println(anInt.hashCode());
    println(aLong.hashCode());
    println(aNullableInt.hashCode(), anotherNullableInt.hashCode());
    println(aBoolean.hashCode(), anotherBoolean.hashCode());
    println(true.hashCode(), false.hashCode());
    println(null, null)

    println(aString.hashCode(), anotherString.hashCode())
    println(Cat(name = "Neo").hashCode(), Cat(name = "Neo").hashCode())

//    val res: Int = aLong // won't compile need to explicitly downcast long to int
    val resultIsInt: Int = aLong.toInt()


//    println(3.0 == 3) // cannot directly equate double and int

    // bitwise operations
    println(1 shl 5) // like 1 << 5 (java)
    println(100 ushr 2) // like 100 >> 2 (java)

    // Miscellaneous
    println(Double.NaN.isNaN())
    println(Double.NaN > Double.POSITIVE_INFINITY) // should return true, but returns false
    println(-0.0 == 0.0) // true

    // unsigned integers
    val uByte: UByte = 255u
    val maxValueMinusUByte = 0u - uByte // overflow!
    println(UInt.MAX_VALUE)
    println(maxValueMinusUByte)

    // booleans
    var isFieldEmpty: Boolean? = null // there is no field
    println(isFieldEmpty ?: "No such field!")

    val nothing: Nothing
    try {
        nothing = throw Error()
        print(nothing is Any)
    }
    // Int() can't access init as it is private
    catch (err: Error) {
        println("throws error")
    }

    val aChar: Char = 'a'

    println(aChar)
    println('\n') // Prints an extra newline character
    println(String(Character.toChars(0x1F60A)))

    // strings
    println("Escaped \nthis\tstring\nhere\ryes")
    println("""Raw string \nthis\tstring\nhere\ryes""")

    val longMessage = """
        |this is 
        |cool
        |maybe
    """.trimMargin()
    println(longMessage)

    // arrays
    val primes = arrayOf(2, 3, 5, 7, 11, 13)
    var squares = Array(10) { it * it }

    // why they differ?
    print("Squares: $squares\n") // [Ljava.lang.Integer;@30c7da1e [it's array]
    val listSquares = squares.map { it }
    print("Squares: ${listSquares}") // [0, 1, 4, 9, 16, 25, 36, 49, 64, 81] [it's list]

    var anyString: Any = "this is string"
//    anyString.length // can't access string specific props
    if (anyString is String) {
        println("\nString length is", anyString.length) //smart cast
        val anyInt = anyString.toIntOrNull()
        println(anyInt)
    }

    // safe cast
    val unknownInt: Any = 2610
    val safeInt = unknownInt as? Int
    println("SafeInt", safeInt)
}