package com.example.androiddemoproject.recyclerview.expandable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.databinding.ActivityExpandableRecyclerViewBinding

class ExpandableRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExpandableRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpandableRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.rvMarvelMovies) {
            addItemDecoration(MovieItemDecoration())
            layoutManager = LinearLayoutManager(
                this@ExpandableRecyclerViewActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = MovieExpandableAdapter(
                movies = getMovies(
                    this@ExpandableRecyclerViewActivity
                )
            )
        }
    }
}