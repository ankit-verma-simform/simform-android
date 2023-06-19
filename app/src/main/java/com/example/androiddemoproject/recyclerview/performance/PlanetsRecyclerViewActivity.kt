package com.example.androiddemoproject.recyclerview.performance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.databinding.ActivityPlanetsRecyclerViewBinding
import com.example.androiddemoproject.recyclerview.listview.getPlanets

class PlanetsRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlanetsRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetsRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPlanetsList.adapter = PlanetsRecyclerViewAdapter(this, getPlanets())
    }
}