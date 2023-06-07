package com.example.androiddemoproject.uiwidgets.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.androiddemoproject.R
import com.google.android.material.checkbox.MaterialCheckBox

class CheckboxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)
        setupTodoCheckListListener()
        setupKotlinCheckboxListener()
    }

    private fun setupKotlinCheckboxListener() {
        val kotlinCheckBox: MaterialCheckBox = findViewById(R.id.checkboxKotlin)
        kotlinCheckBox.setOnCheckedChangeListener { button, isChecked ->
            Toast.makeText(
                this,
                if (isChecked) {
                    getString(R.string.selected_kotlin_message)
                } else {
                    getString(R.string.deselected_kotlin_message)
                },
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setupTodoCheckListListener() {
        val submitTodosButton = findViewById<Button>(R.id.submitTodos)
        submitTodosButton.setOnClickListener {
            notifyAboutSelectedTodos()
        }
    }

    private fun notifyAboutSelectedTodos() {
        val androidPracticeTodo = findViewById<CheckBox>(R.id.doAndroidPractice)
        val iOSPracticeTodo = findViewById<CheckBox>(R.id.doiOSPractice)
        val playChessTodo = findViewById<CheckBox>(R.id.playChess)
        var message = "Todos: "
        if (androidPracticeTodo.isChecked) message += "android, "
        if (iOSPracticeTodo.isChecked) message += "ios, "
        if (playChessTodo.isChecked) message += "chess"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}