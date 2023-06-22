package com.example.androiddemoproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.importantviews.ImportantViewsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtons()
    }

    private fun setupButtons() {
        findViewById<Button>(R.id.btnOtherImportantViews).setOnClickListener {
            Intent(this, ImportantViewsActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}