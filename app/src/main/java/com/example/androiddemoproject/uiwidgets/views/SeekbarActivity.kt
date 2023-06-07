package com.example.androiddemoproject.uiwidgets.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import com.example.androiddemoproject.R

class SeekbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)
        setupSeekbar()
    }

    private fun setupSeekbar() {
        val seekbarText = findViewById<TextView>(R.id.textSeekbar)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)
        seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekbarText.text = "Seekbar: $progress"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@SeekbarActivity, "Touch started", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@SeekbarActivity, "Touch stopped", Toast.LENGTH_SHORT).show()
            }
        })
    }
}