package com.example.androiddemoproject.importantviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityImportantViewsBinding

class ImportantViewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImportantViewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_important_views)
        setupImportantViewsRecyclerView()
    }

    private fun setupImportantViewsRecyclerView() {
        with(binding.rvImportantViews) {
            adapter = ImportantViewsAdapter(
                this@ImportantViewsActivity,
                getImportantViewsNavigationItems()
            )
            layoutManager = LinearLayoutManager(
                this@ImportantViewsActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}