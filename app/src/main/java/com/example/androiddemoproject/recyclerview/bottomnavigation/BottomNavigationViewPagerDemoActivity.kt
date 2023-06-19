package com.example.androiddemoproject.recyclerview.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityBottomNavigationViewPagerDemoBinding

class BottomNavigationViewPagerDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNavigationViewPagerDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationViewPagerDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavBar.setOnItemSelectedListener {
            binding.viewPager.currentItem = when (it.itemId) {
                R.id.calls -> 0
                R.id.chats -> 1
                R.id.contacts -> 2
                else -> return@setOnItemSelectedListener false
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setupViewPager() {
        val adapter = BottomNavigationViewPagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val menuId = when (position) {
                    0 -> R.id.calls
                    1 -> R.id.chats
                    2 -> R.id.contacts
                    else -> 0
                }
                binding.bottomNavBar.menu.findItem(menuId).isChecked = true
            }
        })
    }
}