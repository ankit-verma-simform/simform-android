package com.example.androiddemoproject.converters

import com.example.androiddemoproject.converters.Suit.CLUBS
import com.example.androiddemoproject.converters.Suit.DIAMONDS
import com.example.androiddemoproject.converters.Suit.HEARTS
import com.example.androiddemoproject.converters.Suit.SPADES
import com.squareup.moshi.Moshi

private enum class Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}

private data class Card(
    val rank: Char,
    val suit: Suit
)

private data class BlackjackHand(
    val hiddenCard: Card,
    val visibleCards: List<Card>,
)
fun main() {
    val blackjackHand = BlackjackHand(
        Card('6', SPADES),
        listOf(Card('4', CLUBS), Card('A', HEARTS), Card('A', DIAMONDS))
    )

    val moshi: Moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(BlackjackHand::class.java)

    val blackjackHandJson = adapter.toJson(blackjackHand)
    println(blackjackHandJson)

    val blackjackHandData = adapter.fromJson(blackjackHandJson)
    println(blackjackHandData)
}