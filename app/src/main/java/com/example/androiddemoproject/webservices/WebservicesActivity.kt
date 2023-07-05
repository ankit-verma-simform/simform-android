package com.example.androiddemoproject.webservices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityWebservicesBinding

class WebservicesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebservicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_webservices)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.rvImportantViews) {
            layoutManager = LinearLayoutManager(this@WebservicesActivity)
            adapter = WebservicesAdapter(getWebservicesMainNavigationItems())
        }
    }
}