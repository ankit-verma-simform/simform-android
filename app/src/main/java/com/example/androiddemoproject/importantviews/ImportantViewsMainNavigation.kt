package com.example.androiddemoproject.importantviews

import android.app.Activity
import com.example.androiddemoproject.importantviews.multiplescrollview.MultipleScrollViewActivity
import com.example.androiddemoproject.importantviews.nestedscrollbehaviour.NestedScrollBehaviourActivity
import com.example.androiddemoproject.importantviews.nestedscrollviews.NestedScrollViewsActivity
import com.example.androiddemoproject.importantviews.search.SearchActivity
import com.example.androiddemoproject.importantviews.searchdebounce.SearchDebounceActivity
import com.example.androiddemoproject.importantviews.webview.WebViewActivity

data class ImportantViewsNavigationItem(
    val activity: Class<out Activity>,
    val label: String
)

fun getImportantViewsNavigationItems() = listOf(
    ImportantViewsNavigationItem(
        SearchActivity::class.java,
        "Search Menu"
    ),
    ImportantViewsNavigationItem(
        SearchDebounceActivity::class.java,
        "Search with debounce"
    ),
    ImportantViewsNavigationItem(
        MultipleScrollViewActivity::class.java,
        "Multiple scroll view"
    ),
    ImportantViewsNavigationItem(
        NestedScrollViewsActivity::class.java,
        "Nested scroll view"
    ),
    ImportantViewsNavigationItem(
        WebViewActivity::class.java,
        "Web view"
    ),
    ImportantViewsNavigationItem(
        NestedScrollBehaviourActivity::class.java,
        "Nested scroll with Recycler view"
    ),
)