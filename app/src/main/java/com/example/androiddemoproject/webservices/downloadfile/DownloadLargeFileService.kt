package com.example.androiddemoproject.webservices.downloadfile

import retrofit2.Retrofit
import retrofit2.create

object DownloadLargeFileService {
    private const val BASE_URL = "https://getsamplefiles.com/"

    val instance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
        .create<DownloadApi>()
}