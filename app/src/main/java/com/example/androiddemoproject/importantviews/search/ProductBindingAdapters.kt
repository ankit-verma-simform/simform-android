package com.example.androiddemoproject.importantviews.search

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.androiddemoproject.importantviews.utils.getShimmerDrawable

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url: String) {
    Glide.with(context).load(url).placeholder(getShimmerDrawable()).into(this)
}