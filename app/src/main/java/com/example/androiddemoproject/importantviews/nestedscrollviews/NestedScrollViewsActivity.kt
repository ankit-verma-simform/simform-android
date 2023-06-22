package com.example.androiddemoproject.importantviews.nestedscrollviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityNestedScrollViewsBinding

class NestedScrollViewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNestedScrollViewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nested_scroll_views)
    }
}