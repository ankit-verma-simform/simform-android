package com.example.androiddemoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androiddemoproject.uiwidgets.UIWidgets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationButtons()
    }

    private fun setupNavigationButtons() {
        val uiWidgetsButton: Button = findViewById(R.id.ui_widgets)
        uiWidgetsButton.setOnClickListener {
            val intent = Intent(this, UIWidgets::class.java)
            startActivity(intent)
        }
    }
}