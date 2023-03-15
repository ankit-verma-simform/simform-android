package com.example.androiddemoproject.kotlinbasics

enum class Day {
    MON, TUE, WED, THURS, FRI, SAT, SUN
}

enum class DayType {
    WEEK_DAY, WEEK_END
}

fun main() {

    val today = Day.MON
    val typeOfDay = when (today) {
        Day.MON, Day.TUE, Day.WED, Day.THURS, Day.FRI -> DayType.WEEK_DAY
        Day.SAT, Day.SUN -> DayType.WEEK_END
    }
    val isFreeDay = if (typeOfDay == DayType.WEEK_END) "Yes" else "No"
    println("Are you free today? $isFreeDay")

    print("Days: ")
    for (day in Day.values()) {
        print("$day, ")
    }

    val cubes = Array(11) { it * it * it }
    var sumOfCubes = 0
    for ((num, cube) in cubes.withIndex()) {
        print("Cube of $num is $cube\n")
        sumOfCubes += cube
    }
    println("Sum of cubes is $sumOfCubes")
}