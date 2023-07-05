package com.example.androiddemoproject.webservices.authretrofitrequests.repository

import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresUserList
import com.example.androiddemoproject.webservices.authretrofitrequests.network.ReqresApi
import retrofit2.Response

interface ReqresUserRepository {
    suspend fun getUserList(
        page: Int = 1,
        perPage: Int = 6,
        delay: Int = 0
    ): Response<ReqresUserList>
}

class ReqresUserRepositoryImpl(val api: ReqresApi) : ReqresUserRepository {

    override suspend fun getUserList(
        page: Int,
        perPage: Int,
        delay: Int
    ): Response<ReqresUserList> = api.getUserList(page, perPage, delay)
}
