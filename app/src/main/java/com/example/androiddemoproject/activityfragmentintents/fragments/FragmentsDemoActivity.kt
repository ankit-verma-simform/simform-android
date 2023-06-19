package com.example.androiddemoproject.activityfragmentintents.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityFragmentsDemoBinding

class FragmentsDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentsDemoBinding
    private var fragmentNo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragments_demo)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnAddFragment.setOnClickListener {
            supportFragmentManager.commit {
                fragmentNo++
                add(
                    binding.fragmentContainer.id,
                    TestFragment1(fragmentNo),
                    "fragment$fragmentNo"
                )
                if (binding.chkBoxAddToBackStack.isChecked) addToBackStack(null)
            }
        }
        binding.btnRemoveFragment.setOnClickListener {
            supportFragmentManager.commit {
                supportFragmentManager.findFragmentByTag("fragment$fragmentNo")?.let {
                    remove(it)
                    fragmentNo--
                    if (binding.chkBoxAddToBackStack.isChecked) addToBackStack(null)
                }
            }
        }
        binding.btnReplaceFragment.setOnClickListener {
            supportFragmentManager.commit {
                fragmentNo++
                replace(
                    binding.fragmentContainer.id,
                    TestFragment1(fragmentNo),
                    "fragment$fragmentNo"
                )
                if (binding.chkBoxAddToBackStack.isChecked) addToBackStack(null)
            }
        }
    }
}