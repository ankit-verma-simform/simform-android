package com.example.androiddemoproject.uiwidgets.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androiddemoproject.R

class YellowFragment : TabFragment(
    title = "Yellow",
    icon = R.drawable.home
) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_yellow, container, false)
    }
}