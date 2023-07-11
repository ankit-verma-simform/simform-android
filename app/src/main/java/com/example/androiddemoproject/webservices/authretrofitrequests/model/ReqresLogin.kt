package com.example.androiddemoproject.webservices.authretrofitrequests.model

import com.google.gson.annotations.SerializedName

data class ReqresLoginRequest(
    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String
)

data class ReqresLoginResponse(
    @SerializedName("token")
    val token: String
)

data class ReqresLoginError(
    @SerializedName("error")
    val error: String
)