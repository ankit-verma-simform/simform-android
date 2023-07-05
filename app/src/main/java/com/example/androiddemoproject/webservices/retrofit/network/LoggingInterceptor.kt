package com.example.androiddemoproject.webservices.retrofit.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("TAG", "intercept: $request")
        val response = chain.proceed(request)
        Log.d("TAG", "intercept: $response")
        return response
    }
}