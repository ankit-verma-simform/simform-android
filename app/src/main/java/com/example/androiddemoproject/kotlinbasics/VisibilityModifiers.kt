package com.example.androiddemoproject.kotlinbasics
//
//// private, protected, internal, and public.
//
//// default modifier is public
//
private const val k = 978 // accessible in the same file
// internal -> same module
// protected -> not available for top level declarations

open class Meeting {
    protected var startTime: String = ""

    protected var endTime: String = ""
        private set
}

class VideoMeeting : Meeting() {
    fun setStartTime(startTime: String): String {
        this.startTime = startTime
        return startTime
    }

    fun endTime(endTime: String) {
//        this.endTime = endTime // can't do as setter is private
    }
}

fun main() {
    println(k)
}