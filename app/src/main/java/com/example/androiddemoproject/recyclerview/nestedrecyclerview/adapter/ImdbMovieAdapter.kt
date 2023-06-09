package com.example.androiddemoproject.recyclerview.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.ImdbMovieItemBinding
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.diffutils.ImdbMovieDiffUtils
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.Movie

class ImdbMovieAdapter : ListAdapter<Movie, ImdbMovieAdapter.ViewHolder>(ImdbMovieDiffUtils()) {
    inner class ViewHolder(val binding: ImdbMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                imgMoviePoster.setImageResource(movie.poster)
                tvMovieTitle.text = movie.title
                tvMovieReleaseDate.text = movie.releaseDate
                tvRating.text = movie.ratings.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ImdbMovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}