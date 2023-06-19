package com.example.androiddemoproject.activityfragmentintents.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityReceiveTextFromIntentBinding

class ReceiveTextFromIntentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceiveTextFromIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_receive_text_from_intent)
        intent.action?.let {
            if (it == Intent.ACTION_SEND) {
                val text = intent.getStringExtra(Intent.EXTRA_TEXT) ?: String()
                if (text.isNotEmpty()) {
                    binding.text = text
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}