package com.example.androiddemoproject.webservices.retrofit.network

import com.example.androiddemoproject.webservices.retrofit.model.Todo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoApi {
    @GET("todos")
    suspend fun getTodos(@Query("userId") userId: Int): Response<List<Todo>>
}