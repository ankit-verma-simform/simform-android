package com.example.androiddemoproject.webservices.authretrofitrequests.model


import com.google.gson.annotations.SerializedName

data class ReqresUser(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
)