package com.example.androiddemoproject.revision.codelabexercise

/*
There are three com.example.androiddemoproject.revision.koans.main temperature scales used in the world: Celsius, Fahrenheit, and Kelvin.
In the initial code provided in the following code snippet, write a program that converts a
temperature from one scale to another with these formulas:

Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
Kelvin to Celsius: ° C = K - 273.15
Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15
Note that the String.format("%.2f", /* measurement */ ) method is used to convert a number into a
String type with 2 decimal places.
*/

fun main() {
    // Fill in the code.
    printFinalTemperature(
        initialMeasurement = 27.0, initialUnit = "Celsius", finalUnit = "Fahrenheit",
        conversionFormula = { 9 / 5.0 * it + 32 }
    )

    printFinalTemperature(
        initialMeasurement = 350.0, initialUnit = "Kelvin", finalUnit = "Celsius",
        conversionFormula = { it - 273.15 }
    )

    printFinalTemperature(
        initialMeasurement = 10.0, initialUnit = "Fahrenheit", finalUnit = "Kelvin",
        conversionFormula = { 5 / 9.0 * (it - 32) + 273.15 }
    )
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

/* Required Output:
27.0 degrees Celsius is 80.60 degrees Fahrenheit.
350.0 degrees Kelvin is 76.85 degrees Celsius.
10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
 */