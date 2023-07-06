package com.example.androiddemoproject.activityfragmentintents.fragmentcommunication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityFragmentCommunicationBinding

class FragmentCommunicationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentCommunicationBinding
    private lateinit var viewModel: FragmentCommunicationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_communication)
        setupViewModel()
        setupFragments()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[FragmentCommunicationViewModel::class.java]
    }

    private fun setupFragments() {
        // setting up fragments to demonstrate communication using interface
        val fragmentA = AFragment()
        val fragmentB = BFragment()
        fragmentA.listener = fragmentB

        supportFragmentManager.commit {
            replace(binding.fragmentAContainer.id, fragmentA)
            replace(binding.fragmentBContainer.id, fragmentB)
        }

        // setting up fragments to demonstrate communication using fragment manager
        supportFragmentManager.commit {
            replace(binding.fragmentCContainer.id, CFragment())
            replace(binding.fragmentDContainer.id, DFragment())
        }

        // setting up fragments to demonstrate communication using shared view model
        supportFragmentManager.commit {
            replace(binding.fragmentEContainer.id, EFragment(viewModel))
            replace(binding.fragmentFContainer.id, FFragment(viewModel))
        }
    }
}