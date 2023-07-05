package com.example.androiddemoproject.webservices.authretrofitrequests.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReqresApiService {
    private const val BASE_URL = "https://reqres.in/api/"
    private val client = OkHttpClient.Builder()
        .addInterceptor(ReqresInterceptor())
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ReqresApi = retrofit.create(ReqresApi::class.java)
}