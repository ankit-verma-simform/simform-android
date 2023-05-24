package com.example.androiddemoproject.uiwidgets.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import com.example.androiddemoproject.R

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        setupChooseChessSideListener()
    }

    private fun setupChooseChessSideListener() {
        val chooseChessSide = findViewById<RadioGroup>(R.id.chooseChessSideRadioGroup)
        chooseChessSide.setOnCheckedChangeListener { radioGroup, checkedId ->
            val choosenSide = when (checkedId) {
                R.id.whiteChessSide -> getString(R.string.chosen_white_side)
                R.id.blackChessSide -> getString(R.string.chosen_black_side)
                else -> getString(R.string.no_side_chosen)
            }
            Toast.makeText(this, choosenSide, Toast.LENGTH_SHORT).show()
        }
    }
}