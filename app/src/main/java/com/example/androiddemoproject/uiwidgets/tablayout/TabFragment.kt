package com.example.androiddemoproject.uiwidgets.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment

abstract class TabFragment(
    val title: String,
    @DrawableRes val icon: Int? = null
) : Fragment() {
    abstract override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
}