package com.example.androiddemoproject.recyclerview.multipleviewholders

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HomeItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect) {
            top = 16
            bottom = 16
            left = 16
            right = 16
        }
    }
}