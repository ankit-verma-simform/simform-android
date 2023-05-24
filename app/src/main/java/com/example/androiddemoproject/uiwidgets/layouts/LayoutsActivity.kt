package com.example.androiddemoproject.uiwidgets.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androiddemoproject.R
import com.example.androiddemoproject.uiwidgets.tablayout.TabLayoutActivity

class LayoutsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)
        setupLayoutNavigationButtons()
    }

    private fun setupLayoutNavigationButtons() {
        val linearLayoutButton: Button = findViewById(R.id.linearLayout)
        linearLayoutButton.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        val relativeLayoutButton: Button = findViewById(R.id.relativeLayout)
        relativeLayoutButton.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }

        val tableLayoutButton: Button = findViewById(R.id.tableLayout)
        tableLayoutButton.setOnClickListener {
            val intent = Intent(this, TableLayoutActivity::class.java)
            startActivity(intent)
        }

        val frameLayoutButton: Button = findViewById(R.id.frameLayout)
        frameLayoutButton.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        val constraintLayoutButton: Button = findViewById(R.id.constraintLayout)
        constraintLayoutButton.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        val coordinatorLayoutButton: Button = findViewById(R.id.coordinatorLayout)
        coordinatorLayoutButton.setOnClickListener {
            val intent = Intent(this, CoordinatorLayoutActivity::class.java)
            startActivity(intent)
        }

        val gridLayoutButton: Button = findViewById(R.id.gridLayout)
        gridLayoutButton.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}