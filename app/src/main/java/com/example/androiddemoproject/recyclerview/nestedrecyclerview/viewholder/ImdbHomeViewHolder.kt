package com.example.androiddemoproject.recyclerview.nestedrecyclerview.viewholder

import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.androiddemoproject.databinding.ImdbAdItemBinding
import com.example.androiddemoproject.databinding.ImdbMovieCatalogBinding
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.ImdbHomeItem.Ad
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.ImdbHomeItem.MovieCatalog
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.itemdecoration.ImdbMovieDecoration
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.adapter.ImdbMovieAdapter

sealed class ImdbHomeViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class MovieCatalogViewHolder(val binding: ImdbMovieCatalogBinding) :
        ImdbHomeViewHolder(binding) {
        fun bind(movieCatalog: MovieCatalog) {
            with(binding) {
                tvCatalogTitle.text = movieCatalog.title
                val listAdapter = ImdbMovieAdapter()
                listAdapter.submitList(movieCatalog.movies)
                rvCatalog.adapter = listAdapter
                rvCatalog.addItemDecoration(ImdbMovieDecoration())
                ViewCompat.setNestedScrollingEnabled(rvCatalog, false)
            }
        }
    }

    class AdViewHolder(val binding: ImdbAdItemBinding) : ImdbHomeViewHolder(binding) {
        fun bind(ad: Ad) {
            with(binding) {
                imgAd.setImageResource(ad.image)
                tvAdvertiser.text = ad.advertiser
            }
        }
    }
}