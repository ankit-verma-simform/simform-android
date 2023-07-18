package com.example.androiddemoproject.webservices.authretrofitrequests.utils

data class BasicApiResponse<T>(
    val message: String? = null,
    val successful: Boolean,
    val data: T? = null
)