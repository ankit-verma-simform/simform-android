package com.example.androiddemoproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.importantviews.ImportantViewsActivity
import com.example.androiddemoproject.permissions.PermissionsDemoActivity
import com.example.androiddemoproject.webservices.WebservicesActivity
import com.example.androiddemoproject.uiwidgets.UIWidgets
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

        val uiWidgetsButton: Button = findViewById(R.id.ui_widgets)
        uiWidgetsButton.setOnClickListener {
            val intent = Intent(this, UIWidgets::class.java)
            startActivity(intent)
        }

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

        findViewById<Button>(R.id.btnPermissions).setOnClickListener {
            Intent(this, PermissionsDemoActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}