package com.example.androiddemoproject.webservices.downloadfile

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Streaming

interface DownloadApi {
    @Streaming
    @GET("download/zip/sample-2.zip")
    suspend fun downloadLargeFile(): ResponseBody
}