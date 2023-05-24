package com.example.androiddemoproject.uiwidgets.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiddemoproject.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class FABActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fab)
        customizeFabs()
    }

    private fun customizeFabs() {
        val extendedFab =
            findViewById<ExtendedFloatingActionButton>(R.id.extendedFloatingActionButton)
        extendedFab.setOnClickListener {
            if (extendedFab.isExtended) {
                extendedFab.shrink()
            } else {
                extendedFab.extend()
            }
        }
    }
}