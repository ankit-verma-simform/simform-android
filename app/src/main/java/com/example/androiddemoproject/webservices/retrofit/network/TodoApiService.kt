package com.example.androiddemoproject.webservices.retrofit.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

object TodoApiService {
    private val client = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor())
        .build()

    val instance by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<TodoApi>()
    }
}