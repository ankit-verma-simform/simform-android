package com.example.androiddemoproject.recyclerview.gridview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androiddemoproject.databinding.ActivityAffirmationGridBinding
import com.example.androiddemoproject.recyclerview.listviewviewholderpattern.getAffirmations

class AffirmationGridActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAffirmationGridBinding
    @SuppressLint("NotifyDataSetChanged")
    private val contract = registerForActivityResult(AffirmationsContract()) {
        if (it) binding.rvAffirmations.adapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAffirmationGridBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AffirmationsManager.affirmations = getAffirmations().toMutableList()
        setupAffirmationRecyclerView()
    }

    private fun setupAffirmationRecyclerView() {
        binding.rvAffirmations.apply {
            layoutManager = GridLayoutManager(
                this@AffirmationGridActivity,
                2,
                GridLayoutManager.VERTICAL,
                false
            )
            addItemDecoration(AffirmationItemDecorator())
            adapter = AffirmationRecyclerViewAdapter(
                context = this@AffirmationGridActivity,
                affirmations = AffirmationsManager.affirmations,
                onAffirmationClicked = { _, position ->
                    contract.launch(position)
                }
            )
        }
    }
}