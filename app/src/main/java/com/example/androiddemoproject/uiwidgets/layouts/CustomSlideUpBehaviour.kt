package com.example.androiddemoproject.uiwidgets.layouts

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar


class CustomSlideUpBehaviour(
    context: Context,
    attrs: AttributeSet
) :
    CoordinatorLayout.Behavior<View>(context, attrs) {
    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is Snackbar.SnackbarLayout
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        if (parent == null || child == null || dependency == null) {
            return false
        }
        val translationY = 0f.coerceAtMost(dependency.translationY - dependency.height)
        child.translationY = translationY
        return true
    }

    override fun onDependentViewRemoved(parent: CoordinatorLayout, child: View, dependency: View) {
        if (dependency is Snackbar.SnackbarLayout) {
            moveViewDownUntoVisibleBounds(dependency, child)
        }
    }

    private fun moveViewDownUntoVisibleBounds(dependency: View, child: View) {
        var dependencyHeight = dependency.height
        while (child.isVisible && dependencyHeight > 0) {
            child.translationY = 1f
            dependencyHeight--
        }
    }
}
