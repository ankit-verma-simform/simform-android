package com.example.androiddemoproject.uiwidgets.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.androiddemoproject.R
import com.google.android.material.button.MaterialButtonToggleGroup

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        val toggleButtonGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggleButtonGroup)
        toggleButtonGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            Toast.makeText(this, "Button clicked ${group.checkedButtonId}", Toast.LENGTH_SHORT)
                .show()
        }

        val imgButton = findViewById<ImageButton>(R.id.imgButton)
        imgButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.image_button_clicked), Toast.LENGTH_SHORT)
                .show()
        }
    }
}