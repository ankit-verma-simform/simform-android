package com.example.androiddemoproject.recyclerview.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androiddemoproject.databinding.ActivityPlanetsBinding

class PlanetsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlanetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = PlanetsArrayAdapter(this, getPlanets())
        binding.listPlanets.adapter = adapter
        binding.listPlanets.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this@PlanetsActivity,
                "Planet $position clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}