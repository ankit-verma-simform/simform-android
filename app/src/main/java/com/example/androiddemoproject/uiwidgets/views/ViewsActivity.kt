package com.example.androiddemoproject.uiwidgets.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androiddemoproject.R

class ViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)
        setupNavigationButtons()
    }

    private fun setupNavigationButtons() {
        val textViewButton: Button = findViewById(R.id.textViewActivity)
        textViewButton.setOnClickListener {
            val intent = Intent(this, TextViewActivity::class.java)
            startActivity(intent)
        }

        val editTextButton: Button = findViewById(R.id.editTextActivity)
        editTextButton.setOnClickListener {
            val intent = Intent(this, EditTextActivity::class.java)
            startActivity(intent)
        }

        val button: Button = findViewById(R.id.buttonActivity)
        button.setOnClickListener {
            val intent = Intent(this, ButtonActivity::class.java)
            startActivity(intent)
        }

        val checkBoxButton: Button = findViewById(R.id.checkboxActivity)
        checkBoxButton.setOnClickListener {
            val intent = Intent(this, CheckboxActivity::class.java)
            startActivity(intent)
        }

        val radioButton: Button = findViewById(R.id.radioButtonActivity)
        radioButton.setOnClickListener {
            val intent = Intent(this, RadioButtonActivity::class.java)
            startActivity(intent)
        }

        val fabButton: Button = findViewById(R.id.fabActivity)
        fabButton.setOnClickListener {
            val intent = Intent(this, FABActivity::class.java)
            startActivity(intent)
        }

        val chipsButton: Button = findViewById(R.id.chipsActivity)
        chipsButton.setOnClickListener {
            val intent = Intent(this, ChipsActivity::class.java)
            startActivity(intent)
        }

        val progressbarButton: Button = findViewById(R.id.progressbarActivity)
        progressbarButton.setOnClickListener {
            val intent = Intent(this, ProgressbarActivity::class.java)
            startActivity(intent)
        }

        val spinnerButton: Button = findViewById(R.id.spinnerActivity)
        spinnerButton.setOnClickListener {
            val intent = Intent(this, SpinnerActivity::class.java)
            startActivity(intent)
        }

        val seekbarButton: Button = findViewById(R.id.seekbarActivity)
        seekbarButton.setOnClickListener {
            val intent = Intent(this, SeekbarActivity::class.java)
            startActivity(intent)
        }
    }
}