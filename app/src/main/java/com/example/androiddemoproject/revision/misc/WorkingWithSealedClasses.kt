package com.example.androiddemoproject.revision.misc

sealed class Response {
    data class Success(val data: String? = null) : Response()
    class Failure(val message: String? = null) : Response()
    object Loading : Response()

    companion object {
        val allValues = listOf(Loading, Failure(), Success())
    }

    val type: String = "json/application"
}

fun main() {
    for (resp in Response.allValues) {
        println(resp)
    }

    val success = Response.Success(data = """{data: "some data"}""")
    println("Response type: ${success.type}")

    val map = mapOf(
        Response.Success() to 1,
        Response.Failure() to 2,
        Response.Loading to 3,
    )

    println(map[Response.Success()])
}