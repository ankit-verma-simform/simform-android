package com.example.androiddemoproject.webservices.authretrofitrequests.repository

import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginRequest
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginResponse
import com.example.androiddemoproject.webservices.authretrofitrequests.network.ReqresApi
import retrofit2.Response

interface ReqresAuthRepository {
    suspend fun login(loginRequest: ReqresLoginRequest): Response<ReqresLoginResponse>
}

class ReqresAuthRepositoryImpl(val api: ReqresApi) : ReqresAuthRepository {
    override suspend fun login(loginRequest: ReqresLoginRequest): Response<ReqresLoginResponse> =
        api.login(loginRequest)
}