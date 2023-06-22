package com.example.androiddemoproject.importantviews.multiplescrollview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityMultipleScrollViewBinding

class MultipleScrollViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMultipleScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_multiple_scroll_view)
    }
}