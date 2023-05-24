package com.example.androiddemoproject.uiwidgets.tablayout

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(
    activity: TabLayoutActivity,
    private val tabs: List<Lazy<TabFragment>>
) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabs[position].value
    }
}