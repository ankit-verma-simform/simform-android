package com.example.androiddemoproject.uiwidgets.screens.guestsecurecheckoutscreen

import android.view.View
import androidx.fragment.app.FragmentActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

fun View.setupDateTimePickerOnClickListener(
    fragmentActivity: FragmentActivity,
    onSuccessfulDateTimeSelection: (date: String, time: String) -> Unit
) {
    setOnClickListener {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        datePicker.show(fragmentActivity.supportFragmentManager, "datePicker")
        datePicker.addOnPositiveButtonClickListener {
            val date = datePicker.headerText
            val timePicker = MaterialTimePicker.Builder()
                .setTitleText("Select Time")
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .build()
            timePicker.addOnPositiveButtonClickListener {
                val time = timePicker.getFormattedTime()
                onSuccessfulDateTimeSelection(date, time)
            }
            timePicker.show(fragmentActivity.supportFragmentManager, "timePicker")
        }
    }
}

fun MaterialTimePicker.getFormattedTime(): String =
    when (hour) {
        0 -> String.format("12:%02d AM", minute)
        in 1..11 -> String.format("%02d:%02d AM", hour, minute)
        12 -> String.format("12:%02d PM", minute)
        else -> String.format("%02d:%02d PM", hour - 12, minute)
    }