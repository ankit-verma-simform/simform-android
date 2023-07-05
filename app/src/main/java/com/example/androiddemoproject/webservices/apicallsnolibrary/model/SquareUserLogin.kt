package com.example.androiddemoproject.webservices.apicallsnolibrary.model

import com.example.androiddemoproject.webservices.apicallsnolibrary.utils.tryOrNull
import org.json.JSONObject

data class SquareUserLoginRequest(
    var email: String,
    var password: String
)

data class SquareUserLoginResponse(
    val token: String
)

fun SquareUserLoginRequest.toJsonObject(): JSONObject = JSONObject().apply {
    put("email", email)
    put("password", password)
}

fun JSONObject.toSquareUserLoginResponseOrNull(): SquareUserLoginResponse? = tryOrNull {
    val token = getString("token")
    SquareUserLoginResponse(token)
}
