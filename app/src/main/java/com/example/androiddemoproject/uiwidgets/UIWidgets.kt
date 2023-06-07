package com.example.androiddemoproject.uiwidgets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.R
import com.example.androiddemoproject.uiwidgets.appbarlayout.AppBarLayoutActivity
import com.example.androiddemoproject.uiwidgets.layouts.LayoutsActivity
import com.example.androiddemoproject.uiwidgets.navigation.NavigationActivity
import com.example.androiddemoproject.uiwidgets.screens.guestsecurecheckoutscreen.GuestSecureCheckoutActivity
import com.example.androiddemoproject.uiwidgets.tablayout.TabLayoutActivity
import com.example.androiddemoproject.uiwidgets.views.ViewsActivity

class UIWidgets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uiwidgets)
        setupNavigationButtons()
    }

    private fun setupNavigationButtons() {
        val viewsButton: Button = findViewById(R.id.views)
        viewsButton.setOnClickListener {
            val intent = Intent(this, ViewsActivity::class.java)
            startActivity(intent)
        }

        val layoutButton: Button = findViewById(R.id.layouts)
        layoutButton.setOnClickListener {
            val intent = Intent(this, LayoutsActivity::class.java)
            startActivity(intent)
        }

        val toastButton: Button = findViewById(R.id.toasts)
        toastButton.setOnClickListener {
            val intent = Intent(this, ToastActivity::class.java)
            startActivity(intent)
        }

        val rippleAnimationButton: Button = findViewById(R.id.rippleAnimation)
        rippleAnimationButton.setOnClickListener {
            val intent = Intent(this, RippleAnimationActivity::class.java)
            startActivity(intent)
        }

        val snackBarButton: Button = findViewById(R.id.snackBars)
        snackBarButton.setOnClickListener {
            val intent = Intent(this, SnackbarActivity::class.java)
            startActivity(intent)
        }

        val tabLayoutButton: Button = findViewById(R.id.tabLayoutActivity)
        tabLayoutButton.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
        }

        val appBarLayoutButton: Button = findViewById(R.id.appBarLayout)
        appBarLayoutButton.setOnClickListener {
            val intent = Intent(this, AppBarLayoutActivity::class.java)
            startActivity(intent)
        }

        val datePickerButton: Button = findViewById(R.id.datePicker)
        datePickerButton.setOnClickListener {
            val intent = Intent(this, DatePickerActivity::class.java)
            startActivity(intent)
        }

        val screensButton: Button = findViewById(R.id.screens)
        screensButton.setOnClickListener {
            val intent = Intent(this, GuestSecureCheckoutActivity::class.java)
            startActivity(intent)
        }

        val navigationButton: Button = findViewById(R.id.navigation)
        navigationButton.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
    }
}
