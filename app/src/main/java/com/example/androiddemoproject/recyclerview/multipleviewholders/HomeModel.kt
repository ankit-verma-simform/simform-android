package com.example.androiddemoproject.recyclerview.multipleviewholders

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.androiddemoproject.R
import com.example.androiddemoproject.recyclerview.multipleviewholders.HomeModel.*

sealed class HomeModel {
    data class Movie(
        val title: String,
        val rating: String,
        val year: String,
        val plot: String,
        var isExpanded: Boolean = false
    ) : HomeModel()

    class Ad(@DrawableRes val image: Int) : HomeModel()
}

fun getHomeModelItems(context: Context) = listOf(
    Movie(
        context.getString(R.string.movie1_title),
        context.getString(R.string.movie1_rating),
        context.getString(R.string.movie1_year),
        context.getString(R.string.movie1_plot)
    ),
    Movie(
        context.getString(R.string.movie2_title),
        context.getString(R.string.movie2_rating),
        context.getString(R.string.movie2_year),
        context.getString(R.string.movie2_plot)
    ),
    Movie(
        context.getString(R.string.movie3_title),
        context.getString(R.string.movie3_rating),
        context.getString(R.string.movie3_year),
        context.getString(R.string.movie3_plot)
    ),
    Ad(image = R.drawable.ad),
    Movie(
        context.getString(R.string.movie4_title),
        context.getString(R.string.movie4_rating),
        context.getString(R.string.movie4_year),
        context.getString(R.string.movie4_plot)
    ),
    Movie(
        context.getString(R.string.movie5_title),
        context.getString(R.string.movie5_rating),
        context.getString(R.string.movie5_year),
        context.getString(R.string.movie5_plot)
    ),
    Movie(
        context.getString(R.string.movie6_title),
        context.getString(R.string.movie6_rating),
        context.getString(R.string.movie6_year),
        context.getString(R.string.movie6_plot)
    ),
    Ad(image = R.drawable.ad),
    Movie(
        context.getString(R.string.movie7_title),
        context.getString(R.string.movie7_rating),
        context.getString(R.string.movie7_year),
        context.getString(R.string.movie7_plot)
    ),
    Movie(
        context.getString(R.string.movie8_title),
        context.getString(R.string.movie8_rating),
        context.getString(R.string.movie8_year),
        context.getString(R.string.movie8_plot)
    ),
    Movie(
        context.getString(R.string.movie9_title),
        context.getString(R.string.movie9_rating),
        context.getString(R.string.movie9_year),
        context.getString(R.string.movie9_plot)
    ),
    Ad(image = R.drawable.ad),
    Movie(
        context.getString(R.string.movie10_title),
        context.getString(R.string.movie10_rating),
        context.getString(R.string.movie10_year),
        context.getString(R.string.movie10_plot)
    ),
    Movie(
        context.getString(R.string.movie11_title),
        context.getString(R.string.movie11_rating),
        context.getString(R.string.movie11_year),
        context.getString(R.string.movie11_plot)
    ),
    Movie(
        context.getString(R.string.movie12_title),
        context.getString(R.string.movie12_rating),
        context.getString(R.string.movie12_year),
        context.getString(R.string.movie12_plot)
    ),
    Movie(
        context.getString(R.string.movie13_title),
        context.getString(R.string.movie13_rating),
        context.getString(R.string.movie13_year),
        context.getString(R.string.movie13_plot)
    ),
    Movie(
        context.getString(R.string.movie14_title),
        context.getString(R.string.movie14_rating),
        context.getString(R.string.movie14_year),
        context.getString(R.string.movie14_plot)
    ),
    Movie(
        context.getString(R.string.movie15_title),
        context.getString(R.string.movie15_rating),
        context.getString(R.string.movie15_year),
        context.getString(R.string.movie15_plot)
    ),
    Ad(image = R.drawable.ad),
    Movie(
        context.getString(R.string.movie16_title),
        context.getString(R.string.movie16_rating),
        context.getString(R.string.movie16_year),
        context.getString(R.string.movie16_plot)
    ),
    Movie(
        context.getString(R.string.movie17_title),
        context.getString(R.string.movie17_rating),
        context.getString(R.string.movie17_year),
        context.getString(R.string.movie17_plot)
    ),
)