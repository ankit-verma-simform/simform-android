package com.example.androiddemoproject.webservices.imageupload

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ImgBBApi {
    @Multipart
    @POST("1/upload")
    suspend fun uploadImage(
        @Query("key") key: String,
        @Part image: MultipartBody.Part
    ): Response<ResponseBody>
}