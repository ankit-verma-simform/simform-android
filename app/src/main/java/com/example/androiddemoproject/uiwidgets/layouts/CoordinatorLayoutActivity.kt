package com.example.androiddemoproject.uiwidgets.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androiddemoproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class CoordinatorLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)
        setupAndroidFAB()
        setupCustomBehaviourButton()
    }

    private fun setupAndroidFAB() {
        val fab = findViewById<FloatingActionButton>(R.id.fabAndroid)
        fab.setOnClickListener {
            Snackbar.make(
                it,
                "Android FAB (default behaviour) moves accordingly to Snackbar",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun setupCustomBehaviourButton() {
        val button = findViewById<Button>(R.id.customBehaviorButton)
        button.setOnClickListener {
            Snackbar.make(
                it,
                "Custom behavior moves accordingly to Snackbar",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}