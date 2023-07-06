package com.example.androiddemoproject.activityfragmentintents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityAndroidConceptsBinding

class AndroidConceptsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAndroidConceptsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_android_concepts)
        binding.rvAndroidConcepts.adapter = AndroidConceptsAdapter()
    }
}