package com.example.androiddemoproject.importantviews.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)
        binding.webView.webViewClient = CustomWebViewClient()
        binding.webView.settings.javaScriptEnabled = true
    }

    fun openYoutube(view: View) {
        binding.webView.loadUrl("https://www.youtube.com/")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    fun openGoogle(view: View) {
        binding.webView.loadUrl("https://www.google.com/")
    }

    fun loadCustomHtmlData(view: View) {
        binding.webView.loadData("<b>Hello</b>", "text/html", "UTF-8")
    }
}