package com.example.androiddemoproject.activityfragmentintents.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityReturnWithResultDemoBinding

class ReturnWithResultDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReturnWithResultDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_return_with_result_demo)
        binding.btnReturnWithNewQuery.setOnClickListener {
            setResult(
                Activity.RESULT_OK,
                Intent().apply {
                    putExtra(IntentDemoActivity.NEW_QUERY, binding.etNewQuery.text.toString())
                }
            )
            finish()
        }
    }
}