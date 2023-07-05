package com.example.androiddemoproject.webservices.authretrofitrequests.network

import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginRequest
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginResponse
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresUserList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReqresApi {
    @POST("login")
    suspend fun login(@Body loginRequest: ReqresLoginRequest): Response<ReqresLoginResponse>

    @GET("users")
    suspend fun getUserList(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 6,
        @Query("delay") delay: Int = 0
    ): Response<ReqresUserList>
}