package com.example.androiddemoproject.recyclerview.nestedrecyclerview.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.ImdbHomeItem

class ImdbItemDiffUtils : DiffUtil.ItemCallback<ImdbHomeItem>() {
    override fun areItemsTheSame(oldItem: ImdbHomeItem, newItem: ImdbHomeItem): Boolean {
        return when (oldItem) {
            is ImdbHomeItem.MovieCatalog -> oldItem.title == (newItem as ImdbHomeItem.MovieCatalog).title
            is ImdbHomeItem.Ad -> oldItem.image == (newItem as ImdbHomeItem.Ad).image
        }
    }

    override fun areContentsTheSame(oldItem: ImdbHomeItem, newItem: ImdbHomeItem): Boolean {
        return when (oldItem) {
            is ImdbHomeItem.MovieCatalog -> oldItem.movies == (newItem as ImdbHomeItem.MovieCatalog).movies
            is ImdbHomeItem.Ad -> oldItem == (newItem as ImdbHomeItem.Ad)
        }
    }
}