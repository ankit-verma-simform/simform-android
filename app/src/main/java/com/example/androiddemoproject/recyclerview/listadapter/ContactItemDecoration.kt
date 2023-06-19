package com.example.androiddemoproject.recyclerview.listadapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ContactItemDecoration : RecyclerView.ItemDecoration() {
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
            right = 16
            left = 16
        }
    }
}