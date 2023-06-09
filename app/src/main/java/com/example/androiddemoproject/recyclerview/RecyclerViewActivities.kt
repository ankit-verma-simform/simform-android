package com.example.androiddemoproject.recyclerview

import android.app.Activity
import com.example.androiddemoproject.recyclerview.bottomnavigation.BottomNavigationViewPagerDemoActivity
import com.example.androiddemoproject.recyclerview.editablerecyclerview.EditableRecyclerViewActivity
import com.example.androiddemoproject.recyclerview.expandable.ExpandableRecyclerViewActivity
import com.example.androiddemoproject.recyclerview.gridview.AffirmationGridActivity
import com.example.androiddemoproject.recyclerview.listadapter.ListAdapterActivity
import com.example.androiddemoproject.recyclerview.listview.PlanetsActivity
import com.example.androiddemoproject.recyclerview.listviewviewholderpattern.AffirmationListActivity
import com.example.androiddemoproject.recyclerview.multipleviewholders.MultipleViewHoldersDemoActivity
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.ImdbMovieActivity
import com.example.androiddemoproject.recyclerview.performance.PlanetsRecyclerViewActivity
import com.example.androiddemoproject.recyclerview.viewpager2.ViewPager2Activity

data class NavigationActivityItem(
    val activity: Class<out Activity>,
    val label: String?
)

object RecyclerViewActivities {
    fun getRecyclerViewActivities() = listOf(
        NavigationActivityItem(PlanetsActivity::class.java, label = "Planets List View"),
        NavigationActivityItem(
            PlanetsRecyclerViewActivity::class.java,
            label = "Planets Recycler View"
        ),
        NavigationActivityItem(
            AffirmationListActivity::class.java,
            label = "Affirmations View Holder Pattern"
        ),
        NavigationActivityItem(
            AffirmationGridActivity::class.java,
            label = "Affirmations Grid Recycler View"
        ),
        NavigationActivityItem(
            EditableRecyclerViewActivity::class.java,
            label = "Todo Editable Recycler View"
        ),
        NavigationActivityItem(
            ViewPager2Activity::class.java,
            label = "ViewPager with Recycler View"
        ),
        NavigationActivityItem(
            ExpandableRecyclerViewActivity::class.java,
            label = "Expandable Items with Recycler View"
        ),
        NavigationActivityItem(
            MultipleViewHoldersDemoActivity::class.java,
            label = "Multiple View Holders with Recycler View"
        ),
        NavigationActivityItem(
            ListAdapterActivity::class.java,
            label = "List Adapter with DiffUtils"
        ),
        NavigationActivityItem(
            ImdbMovieActivity::class.java,
            label = "Imdb Movies [Nested Recycler View]"
        ),
        NavigationActivityItem(
            BottomNavigationViewPagerDemoActivity::class.java,
            label = "Bottom Navigation with ViewPager2"
        ),
    )
}