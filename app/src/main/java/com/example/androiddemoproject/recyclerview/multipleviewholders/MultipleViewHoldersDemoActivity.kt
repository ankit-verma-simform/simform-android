package com.example.androiddemoproject.recyclerview.multipleviewholders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.databinding.ActivityMultipleViewHoldersDemoBinding

class MultipleViewHoldersDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMultipleViewHoldersDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleViewHoldersDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvHome.adapter = HomeAdapter(getHomeModelItems(this))
        binding.rvHome.addItemDecoration(HomeItemDecoration())
    }
}