package com.example.androiddemoproject.kotlinbasics

sealed interface HttpError {
    data class Unauthorized(val reason: String) : HttpError
    object NotFound : HttpError
    data class BadRequest(val reason: String) : HttpError
}

fun main() {
    val httpError: HttpError = HttpError.BadRequest("missing fields in request!")
    when (httpError) {
        is HttpError.BadRequest -> println("We cannot complete the request because ${httpError.reason}")
        HttpError.NotFound -> println("Page you are looking for is not found!")
        is HttpError.Unauthorized -> println("You are not authorized to access this page because ${httpError.reason}")
    }
}