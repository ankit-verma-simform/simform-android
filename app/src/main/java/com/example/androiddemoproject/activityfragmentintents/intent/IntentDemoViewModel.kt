package com.example.androiddemoproject.activityfragmentintents.intent

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddemoproject.activityfragmentintents.activitylifecycle.ActivityLifecycleDemoActivity

class IntentDemoViewModel : ViewModel() {
    var searchQuery = MutableLiveData<String>()

    fun explicitIntentButtonClicked(view: View) {
        val intent = Intent(view.context, ActivityLifecycleDemoActivity::class.java)
        startActivity(view.context, intent, null)
    }

    fun openGoogleButtonClicked(view: View) {
        val niaUrl = "https://developer.android.com/series/now-in-android"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(niaUrl))
        startActivity(view.context, intent, null)
    }

    fun openDemoBrowserButtonClicked(view: View) {
        val intent = Intent(view.context, IntentBrowserDemoActivity::class.java).apply {
            putExtra("SEARCH_QUERY", searchQuery.value)
        }
        startActivity(view.context, intent, null)
    }

    fun btnShareSearchQueryClicked(view: View) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, searchQuery.value)

        }
        startActivity(view.context, intent, null)
    }
}