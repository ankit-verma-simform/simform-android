package com.example.androiddemoproject.recyclerview.listviewviewholderpattern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.databinding.ActivityAffirmationListBinding

class AffirmationListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAffirmationListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAffirmationListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listAffirmations.adapter = AffirmationListAdapter(this, getAffirmations())
    }
}