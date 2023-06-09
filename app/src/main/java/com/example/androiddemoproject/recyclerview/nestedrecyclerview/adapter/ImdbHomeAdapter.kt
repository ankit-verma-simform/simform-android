package com.example.androiddemoproject.recyclerview.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ImdbAdItemBinding
import com.example.androiddemoproject.databinding.ImdbMovieCatalogBinding
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.ImdbHomeItem
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.viewholder.ImdbHomeViewHolder
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.diffutils.ImdbItemDiffUtils

class ImdbHomeAdapter : ListAdapter<ImdbHomeItem, ImdbHomeViewHolder>(ImdbItemDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImdbHomeViewHolder {
        return when (viewType) {
            R.layout.imdb_movie_catalog -> {
                val binding = ImdbMovieCatalogBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ImdbHomeViewHolder.MovieCatalogViewHolder(binding)
            }

            R.layout.imdb_ad_item -> {
                val binding = ImdbAdItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ImdbHomeViewHolder.AdViewHolder(binding)
            }

            else -> throw IllegalArgumentException("No such view holder!")
        }
    }

    override fun onBindViewHolder(holder: ImdbHomeViewHolder, position: Int) {
        when (holder) {
            is ImdbHomeViewHolder.MovieCatalogViewHolder -> {
                val movieCatalog = getItem(position) as ImdbHomeItem.MovieCatalog
                holder.bind(movieCatalog)
            }

            is ImdbHomeViewHolder.AdViewHolder -> {
                val ad = getItem(position) as ImdbHomeItem.Ad
                holder.bind(ad)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ImdbHomeItem.MovieCatalog -> R.layout.imdb_movie_catalog
            is ImdbHomeItem.Ad -> R.layout.imdb_ad_item
        }
    }
}