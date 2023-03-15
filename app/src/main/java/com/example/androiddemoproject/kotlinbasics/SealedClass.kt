package com.example.androiddemoproject.kotlinbasics

data class Data(val msg: String)

sealed class Response {
    data class Success(val data: Data) : Response()
    object Error: Response()
    object Loading: Response()
}

sealed class Tile
class Red(val type: String, val points: Int): Tile()
class Blue(val points: Int): Tile()

fun main() {
    val tile: Tile = Red("mushroom", 10)
    val result = when(tile) {
        is Red -> 0
        is Blue -> 9
    }
}