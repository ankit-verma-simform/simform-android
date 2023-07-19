package com.example.androiddemoproject.webservices.imageupload

import retrofit2.Retrofit

object ImgBBApiService {
    private const val BASE_URL = "https://api.imgbb.com/"
    val instance: ImgBBApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
        .create(ImgBBApi::class.java)
}