package com.example.androiddemoproject.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.androiddemoproject.R
import com.google.android.material.snackbar.Snackbar

class SnackbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)
        setupSnackBars()
    }

    private fun setupSnackBars() {
        val snackbarButton = findViewById<Button>(R.id.normalSnackBar)
        snackbarButton.setOnClickListener {
            Snackbar.make(
                it, getString(R.string.normal_snack_bar_message),
                Snackbar.LENGTH_SHORT
            )
                .show()
        }

        val snackbarWithActionButton = findViewById<Button>(R.id.normalSnackBarWithAction)
        snackbarWithActionButton.setOnClickListener {
            Snackbar.make(
                it,
                getString(R.string.normal_snackbar_with_action_message),
                Snackbar.LENGTH_LONG
            )
                .setAction("Action") {
                    Toast.makeText(
                        this,
                        getString(R.string.snackbar_action_clicked_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .show()
        }
    }
}