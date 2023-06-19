package com.example.androiddemoproject.recyclerview.multipleviewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.androiddemoproject.databinding.AdItemBinding
import com.example.androiddemoproject.databinding.MovieItemBinding

sealed class HomeViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class MarvelMovieViewHolder(val binding: MovieItemBinding) : HomeViewHolder(binding) {
        fun bind(movie: HomeModel.Movie) {
            with(binding) {
                tvTitle.text = movie.title
                expandableLayout.visibility = if (movie.isExpanded) View.VISIBLE else View.GONE
                if (movie.isExpanded) {
                    yearTextView.text = movie.year
                    plotTextView.text = movie.plot
                    ratingTextView.text = movie.rating
                }
            }
        }
    }

    class AdViewHolder(val binding: AdItemBinding) : HomeViewHolder(binding) {
        fun bind(ad: HomeModel.Ad) {
            binding.imgAd.setImageResource(ad.image)
        }
    }
}