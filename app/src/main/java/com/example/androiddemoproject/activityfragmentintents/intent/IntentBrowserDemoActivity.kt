package com.example.androiddemoproject.activityfragmentintents.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityIntentBrowserDemoBinding

class IntentBrowserDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentBrowserDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intent_browser_demo)
        binding.webView.webViewClient = WebViewClient()
        intent.getStringExtra("SEARCH_QUERY")?.let {
            binding.webView.loadUrl("https://www.google.com/search?q=$it")
        }
    }
}