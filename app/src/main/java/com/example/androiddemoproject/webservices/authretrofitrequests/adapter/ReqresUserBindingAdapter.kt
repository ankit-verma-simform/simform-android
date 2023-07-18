package com.example.androiddemoproject.webservices.authretrofitrequests.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

@BindingAdapter("android:loadImageFromUrl")
fun ImageView.loadImageFromUrl(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .transform(CircleCrop())
        .into(this)
}