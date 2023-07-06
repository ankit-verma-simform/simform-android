package com.example.androiddemoproject.webservices

import android.app.Activity
import com.example.androiddemoproject.webservices.apicallsnolibrary.view.ManualApiCallsActivity

data class WebservicesMainNavigation(
    val activity: Class<out Activity>,
    val label: String
)

fun getWebservicesMainNavigationItems() = listOf(
    WebservicesMainNavigation(
        ManualApiCallsActivity::class.java,
        "Manual API Call HttpConnection"
    )
)