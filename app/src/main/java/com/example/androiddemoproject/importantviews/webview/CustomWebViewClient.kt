package com.example.androiddemoproject.importantviews.webview

import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class CustomWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        Log.d("TAG", "shouldOverrideUrlLoading: ${request?.url?.host ?: ""}")
        // restricting stackoverflow
        if (request?.url?.host == "stackoverflow.com") {
            return true
        }
        return super.shouldOverrideUrlLoading(view, request)
    }
}