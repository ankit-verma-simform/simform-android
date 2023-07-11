package com.example.androiddemoproject.webservices.authretrofitrequests.network

import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginRequest
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ReqresApi {
    @POST("login")
    suspend fun login(@Body loginRequest: ReqresLoginRequest): Response<ReqresLoginResponse>
}