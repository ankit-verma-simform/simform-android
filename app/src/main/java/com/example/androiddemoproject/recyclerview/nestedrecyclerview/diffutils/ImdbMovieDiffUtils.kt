package com.example.androiddemoproject.recyclerview.nestedrecyclerview.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.Movie

class ImdbMovieDiffUtils : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.poster == newItem.poster
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}