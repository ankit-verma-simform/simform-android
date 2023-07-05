package com.example.androiddemoproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.importantviews.ImportantViewsActivity
import com.example.androiddemoproject.activityfragmentintents.AndroidConceptsActivity
import com.example.androiddemoproject.webservices.WebservicesActivity

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

    private fun setupButtons() {
        findViewById<Button>(R.id.btnOtherImportantViews).setOnClickListener {
            Intent(this, ImportantViewsActivity::class.java).also {
                startActivity(it)
            }
        }

        findViewById<Button>(R.id.btnWebservices).setOnClickListener {
            Intent(this, WebservicesActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}