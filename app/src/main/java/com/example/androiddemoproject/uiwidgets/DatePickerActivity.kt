package com.example.androiddemoproject.uiwidgets

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.R
import com.google.android.material.datepicker.MaterialDatePicker

class DatePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        setupDatePicker()
    }

    private fun setupDatePicker() {
        val dateText = findViewById<TextView>(R.id.date)
        val datePickerButton = findViewById<Button>(R.id.datePickerButton)
        datePickerButton.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()
            datePicker.show(supportFragmentManager, "datePicker")
            datePicker.addOnPositiveButtonClickListener {
                dateText.text = "Selected date is ${datePicker.headerText}"
            }
        }
    }
}