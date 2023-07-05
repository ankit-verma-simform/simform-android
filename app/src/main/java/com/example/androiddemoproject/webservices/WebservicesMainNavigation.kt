package com.example.androiddemoproject.webservices

import android.app.Activity
import com.example.androiddemoproject.webservices.apicallsnolibrary.view.ManualApiCallsActivity
import com.example.androiddemoproject.webservices.authretrofitrequests.view.RetrofitAuthDemoActivity
import com.example.androiddemoproject.webservices.checknetworkavailability.ConnectivityDemoActivity
import com.example.androiddemoproject.webservices.downloadfile.DownloadLargeFileActivity
import com.example.androiddemoproject.webservices.imageupload.ImgBBActivity
import com.example.androiddemoproject.webservices.okhttp.OKHttpDemoActivity
import com.example.androiddemoproject.webservices.retrofit.view.RetrofitActivity

data class WebservicesMainNavigation(
    val activity: Class<out Activity>,
    val label: String
)

fun getWebservicesMainNavigationItems() = listOf(
    WebservicesMainNavigation(
        ManualApiCallsActivity::class.java,
        "Manual API Call HttpConnection"
    ),
    WebservicesMainNavigation(
        RetrofitActivity::class.java,
        "Retrofit API Call"
    ),
    WebservicesMainNavigation(
        ConnectivityDemoActivity::class.java,
        "Check Internet Connection Status"
    ),
    WebservicesMainNavigation(
        ImgBBActivity::class.java,
        "Image Upload Retrofit"
    ),
    WebservicesMainNavigation(
        DownloadLargeFileActivity::class.java,
        "Download File Retrofit"
    ),
    WebservicesMainNavigation(
        RetrofitAuthDemoActivity::class.java,
        "Reqres App Auth Demo Retrofit"
    ),
    WebservicesMainNavigation(
        OKHttpDemoActivity::class.java,
        "Reqres App OKHttp Demo"
    )
)