package com.example.androiddemoproject.webservices.authretrofitrequests.network

import android.util.Log
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.TokenManager
import okhttp3.Interceptor
import okhttp3.Response

class ReqresInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("TAG", "intercept: ${request.url.encodedPath}")
        val newRequest = if (request.url.encodedPath == "/api/login") {
            request
        } else {
            request.newBuilder()
                .addHeader("Authorization", TokenManager.token)
                .build()
        }
        return chain.proceed(newRequest)
    }
}