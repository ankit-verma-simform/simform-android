package com.example.androiddemoproject.recyclerview.multipleviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.AdItemBinding
import com.example.androiddemoproject.databinding.MovieItemBinding

class HomeAdapter(private val homeItems: List<HomeModel>) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        when (viewType) {
            R.layout.ad_item -> {
                val binding = AdItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return HomeViewHolder.AdViewHolder(binding)
            }

            R.layout.movie_item -> {
                val binding = MovieItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return HomeViewHolder.MarvelMovieViewHolder(binding)
            }

            else -> throw IllegalArgumentException("No such view holder type!")
        }
    }

    override fun getItemCount(): Int = homeItems.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder.AdViewHolder -> {
                val adItem = homeItems[position] as HomeModel.Ad
                holder.bind(adItem)
            }

            is HomeViewHolder.MarvelMovieViewHolder -> {
                val movieItem = homeItems[position] as HomeModel.Movie
                holder.bind(movieItem)
                holder.binding.root.setOnClickListener {
                    movieItem.isExpanded = !movieItem.isExpanded
                    notifyItemChanged(position)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (homeItems[position]) {
            is HomeModel.Ad -> R.layout.ad_item
            is HomeModel.Movie -> R.layout.movie_item
        }
    }
}