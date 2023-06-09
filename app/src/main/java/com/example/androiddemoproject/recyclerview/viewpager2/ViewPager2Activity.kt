package com.example.androiddemoproject.recyclerview.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.androiddemoproject.databinding.ActivityViewPager2Binding

class ViewPager2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPager2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPager2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_VERTICAL
        binding.viewpager.adapter = FoodViewPager2Adapter()
        binding.button.setOnClickListener {
            binding.viewpager.setCurrentItem(0, true)
        }
    }
}