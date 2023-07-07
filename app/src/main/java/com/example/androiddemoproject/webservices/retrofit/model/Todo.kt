package com.example.androiddemoproject.webservices.retrofit.model

data class Todo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)