package com.example.androiddemoproject.webservices.authretrofitrequests.model


import com.google.gson.annotations.SerializedName

data class ReqresUserList(
    @SerializedName("data")
    val users: List<ReqresUser>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)