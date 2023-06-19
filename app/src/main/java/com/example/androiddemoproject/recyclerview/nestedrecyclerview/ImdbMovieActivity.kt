package com.example.androiddemoproject.recyclerview.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import com.example.androiddemoproject.databinding.ActivityImdbmovieBinding
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.adapter.ImdbHomeAdapter
import com.example.androiddemoproject.recyclerview.nestedrecyclerview.itemdecoration.ImdbHomeItemDecoration

class ImdbMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImdbmovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImdbmovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupImdbHomeRecyclerView()
    }

    private fun setupImdbHomeRecyclerView() {
        with(binding.rvIMDBHome) {
            val listAdapter = ImdbHomeAdapter()
            listAdapter.submitList(getImdbHomeItems())
            adapter = listAdapter
            addItemDecoration(ImdbHomeItemDecoration())
            ViewCompat.setNestedScrollingEnabled(this, false)
        }
    }
}