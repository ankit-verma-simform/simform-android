package com.example.androiddemoproject.uiwidgets.views

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView
import com.example.androiddemoproject.R

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        setMultiStyleText()
    }

    private fun setMultiStyleText() {
        val textView = findViewById<TextView>(R.id.mutlistyleText)
        val formattedText = getString(R.string.spannable_text_message)
        val spannable = SpannableString(formattedText)
        spannable.setSpan(ForegroundColorSpan(Color.RED), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 11, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannable
    }
}