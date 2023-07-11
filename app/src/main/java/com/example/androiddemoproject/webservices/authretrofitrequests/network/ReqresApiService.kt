package com.example.androiddemoproject.webservices.authretrofitrequests.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReqresApiService {
    private const val BASE_URL = "https://reqres.in/api/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ReqresApi = retrofit.create(ReqresApi::class.java)
}