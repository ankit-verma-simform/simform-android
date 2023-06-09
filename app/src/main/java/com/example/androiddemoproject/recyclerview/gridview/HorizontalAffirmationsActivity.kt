package com.example.androiddemoproject.recyclerview.gridview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.androiddemoproject.databinding.ActivityHorizontalAffirmationsBinding

class HorizontalAffirmationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHorizontalAffirmationsBinding
    private var result = Intent().putExtra(AffirmationsContract.ANY_AFFIRMATION_DELETED, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalAffirmationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setResult(RESULT_OK, result)
    }

    private fun setupRecyclerView() {
        with(binding.rvAffirmations) {
            adapter = HorizontalAffirmationsAdapter(
                this@HorizontalAffirmationsActivity,
                AffirmationsManager.affirmations,
                onAffirmationsDeleted = {
                    result = Intent().putExtra(AffirmationsContract.ANY_AFFIRMATION_DELETED, true)
                    setResult(RESULT_OK, result)
                }
            )
            PagerSnapHelper().attachToRecyclerView(this)
            val scrollPosition = intent.getIntExtra(AffirmationsContract.SCROLL_POSITION, 0)
            scrollToPosition(scrollPosition)
            addItemDecoration(AffirmationItemDecorator())
        }
    }
}