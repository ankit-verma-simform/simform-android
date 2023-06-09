package com.example.androiddemoproject.recyclerview.nestedrecyclerview

import androidx.annotation.DrawableRes
import com.example.androiddemoproject.R
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.ImdbHomeItem.*

sealed class ImdbHomeItem {
    data class MovieCatalog(val title: String, val movies: List<Movie>) : ImdbHomeItem()
    data class Ad(@DrawableRes val image: Int, val advertiser: String) : ImdbHomeItem()
}

data class Movie(
    @DrawableRes val poster: Int,
    val title: String,
    val releaseDate: String,
    val ratings: Int
)

fun getImdbHomeItems() = listOf(
    Ad(image = R.drawable.amazon_prime_ad, advertiser = "Amazon"),
    MovieCatalog(
        title = "Trending",
        movies = listOf(
            Movie(
                poster = R.drawable.fast_x,
                title = "Fast X",
                releaseDate = "17 May 2023",
                ratings = 74
            ),
            Movie(
                poster = R.drawable.john_wick,
                title = "John Wick",
                releaseDate = "22 May 2023",
                ratings = 79
            ),
            Movie(
                poster = R.drawable.transformers,
                title = "Transformers",
                releaseDate = "06 Jun 2023",
                ratings = 74
            ),
            Movie(
                poster = R.drawable.flash,
                title = "Flash",
                releaseDate = "13 Jun 2023",
                ratings = 61
            ),
            Movie(
                poster = R.drawable.bloodhounds,
                title = "Bloodhounds",
                releaseDate = "09 Jun 2023",
                ratings = 84
            ),
        )
    ),
    Ad(image = R.drawable.ad, advertiser = "Amazon"),
    MovieCatalog(
        title = "Latest Trailers",
        movies = listOf(
            Movie(
                poster = R.drawable.fast_x,
                title = "Fast X",
                releaseDate = "17 May 2023",
                ratings = 74
            ),
            Movie(
                poster = R.drawable.john_wick,
                title = "John Wick",
                releaseDate = "22 May 2023",
                ratings = 79
            ),
            Movie(
                poster = R.drawable.transformers,
                title = "Transformers",
                releaseDate = "06 Jun 2023",
                ratings = 74
            ),
            Movie(
                poster = R.drawable.flash,
                title = "Flash",
                releaseDate = "13 Jun 2023",
                ratings = 61
            ),
            Movie(
                poster = R.drawable.bloodhounds,
                title = "Bloodhounds",
                releaseDate = "09 Jun 2023",
                ratings = 84
            ),
        )
    ),
    MovieCatalog(
        title = "What's Popular",
        movies = listOf(
            Movie(
                poster = R.drawable.fast_x,
                title = "Fast X",
                releaseDate = "17 May 2023",
                ratings = 74
            ),
            Movie(
                poster = R.drawable.john_wick,
                title = "John Wick",
                releaseDate = "22 May 2023",
                ratings = 79
            ),
            Movie(
                poster = R.drawable.transformers,
                title = "Transformers",
                releaseDate = "06 Jun 2023",
                ratings = 74
            ),
            Movie(
                poster = R.drawable.flash,
                title = "Flash",
                releaseDate = "13 Jun 2023",
                ratings = 61
            ),
            Movie(
                poster = R.drawable.bloodhounds,
                title = "Bloodhounds",
                releaseDate = "09 Jun 2023",
                ratings = 84
            ),
        )
    ),
)