package com.example.androiddemoproject.revision.codelabexercise

/*
Imagine that you need to create a music-player app.
Create a class that can represent the structure of a song. The Song class must include these
code elements:

Properties for the title, artist, year published, and play count
A property that indicates whether the song is popular. If the play count is less than 1,000,
consider it unpopular.
A method that prints a song description in this format:
"[Title], performed by [artist], was released in [year published]."
 */

class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
) {

    var playCount: Int = 999
        private set
    val isPopular get() = playCount >= 1000

    override fun toString() = "$title, performed by $artist, was released in $yearPublished."

    fun play() {
        println("Playing song - $title ...")
        ++playCount
    }
}

fun main() {
    val song = Song("Song 123", "Unknown Artist", 2009)
    println(song.isPopular)
    song.play()
    println(song.isPopular)
    println(song)
}