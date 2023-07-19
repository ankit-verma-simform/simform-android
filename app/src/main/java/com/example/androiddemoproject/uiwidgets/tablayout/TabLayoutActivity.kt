package com.example.androiddemoproject.uiwidgets.tablayout

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.androiddemoproject.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {

    private val tabs = listOf(
        lazy { RedFragment() },
        lazy { YellowFragment() },
        lazy { GreenFragment() },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val adapter = ViewPager2Adapter(this, tabs)

        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = tabs[position].value.title
            tabs[position].value.icon?.let {
                tab.setIcon(it)
            }
            if (position == 0) {
                tab.orCreateBadge.apply {
                    number = 10
                    backgroundColor = Color.CYAN
                }
            }
        }.attach()

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@TabLayoutActivity,
                    "${tab?.text} selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@TabLayoutActivity,
                    "${tab?.text} unselected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@TabLayoutActivity,
                    "${tab?.text} reselected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}