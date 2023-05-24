package com.example.androiddemoproject.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.example.androiddemoproject.R

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        setupToasts()
    }

    private fun setupToasts() {
        val normalToastButton = findViewById<Button>(R.id.normalToastButton)
        normalToastButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.normal_toast_message), Toast.LENGTH_LONG).show()
        }

        val customToastButton = findViewById<Button>(R.id.customToastButton)
        customToastButton.setOnClickListener {
            Toast(this).apply {
                setGravity(Gravity.CENTER, 0, 0)
                duration = Toast.LENGTH_LONG
                // view is deprecated with no new alternative; but is needed for inflating custom toast layout
                view = layoutInflater.inflate(
                    R.layout.custom_toast_layout,
                    findViewById(R.id.llCustomToast)
                )
                show()
            }
        }
    }
}