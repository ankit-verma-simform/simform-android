package com.example.androiddemoproject.webservices.apicallsnolibrary.utils

fun <T>tryOrNull(block: () -> T): T? {
    return try {
        block()
    } catch (e: Exception) {
        null
    }
}