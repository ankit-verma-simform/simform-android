package com.example.androiddemoproject.activityfragmentintents

import android.app.Activity
import com.example.androiddemoproject.activityfragmentintents.activitylifecycle.ActivityLifecycleDemoActivity
import com.example.androiddemoproject.activityfragmentintents.fragmentcommunication.FragmentCommunicationActivity
import com.example.androiddemoproject.activityfragmentintents.fragments.FragmentsDemoActivity
import com.example.androiddemoproject.activityfragmentintents.intent.IntentDemoActivity
import com.example.androiddemoproject.activityfragmentintents.pendingintents.PendingIntentDemoActivity

data class AndroidConceptNavigationItem(
    val activity: Class<out Activity>,
    val label: String
)

fun getAndroidConceptsNavigationItems() = listOf(
    AndroidConceptNavigationItem(
        ActivityLifecycleDemoActivity::class.java,
        "Activity Lifecycle"
    ),
    AndroidConceptNavigationItem(
        IntentDemoActivity::class.java,
        "Intent"
    ),
    AndroidConceptNavigationItem(
        FragmentsDemoActivity::class.java,
        "Fragments Basic Concepts"
    ),
    AndroidConceptNavigationItem(
        FragmentCommunicationActivity::class.java,
        "Fragments Communication"
    ),
    AndroidConceptNavigationItem(
        PendingIntentDemoActivity::class.java,
        "Pending Intents"
    ),
)