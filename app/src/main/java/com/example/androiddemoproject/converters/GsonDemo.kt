package com.example.androiddemoproject.converters

import com.google.gson.Gson

private data class Todo(
    val completed: Boolean, val id: Int, val title: String, val userId: Int,
    val dependsOn: Todo? = null
)

fun main() {
    // Gson
    val gson = Gson()
    val todo = Todo(
        completed = false, id = 3, title = "Android Coroutines", userId = 5,
        Todo(completed = true, id = 1, title = "Android Threads", userId = 5)
    )

    val todoJson = gson.toJson(todo, Todo::class.java)
    println(todoJson)

    val todoData = gson.fromJson(todoJson, Todo::class.java)
    println(todoData)
}