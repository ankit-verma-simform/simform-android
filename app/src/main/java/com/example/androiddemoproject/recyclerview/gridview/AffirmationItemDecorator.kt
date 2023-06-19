package com.example.androiddemoproject.recyclerview.gridview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AffirmationItemDecorator(
    private val marginTop: Int = 10,
    private val marginBottom: Int = 10,
    private val marginLeft: Int = 10,
    private val marginRight: Int = 10,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.apply {
            top = marginTop
            bottom = marginBottom
            left = marginLeft
            right = marginRight
        }
    }
}