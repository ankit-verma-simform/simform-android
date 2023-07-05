package com.example.androiddemoproject.webservices.apicallsnolibrary.network

sealed class ResponseState<out T> {
    object Loading : ResponseState<Nothing>()
    object NotLoading : ResponseState<Nothing>()
    data class Error(val throwable: Throwable) : ResponseState<Nothing>()
    data class Success<T>(val item: T) : ResponseState<T>()
}