package com.example.androiddemoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androiddemoproject.activityfragmentintents.AndroidConceptsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtons()
    }

    private fun setupButtons() {
        findViewById<Button>(R.id.btnActivityFragmentIntent).setOnClickListener {
            Intent(this, AndroidConceptsActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}