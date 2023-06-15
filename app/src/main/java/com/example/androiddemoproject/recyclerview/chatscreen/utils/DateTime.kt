package com.example.androiddemoproject.recyclerview.chatscreen.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getCurrentDateTime(): Pair<String, String> {
    val calendar = Calendar.getInstance()
    val date = SimpleDateFormat("dd MMMM yyyy", Locale.US).format(calendar.time)
    val time = SimpleDateFormat("h:mm", Locale.US).format(calendar.time)
    val amOrPm = SimpleDateFormat("a", Locale.US).format(calendar.time).uppercase()
    return Pair(date, "$time $amOrPm")
}
