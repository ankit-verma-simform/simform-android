package com.example.androiddemoproject.webservices.authretrofitrequests.utils

sealed class UIState<T : Any> {
    data class Initial<T : Any>(val data: T? = null) : UIState<T>()
    data class Loading<T : Any>(val progress: Int? = null) : UIState<T>()
    data class Success<T : Any>(val data: T? = null) : UIState<T>()
    data class Error<T : Any>(val message: String, val throwable: Throwable? = null) : UIState<T>()
}