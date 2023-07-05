package com.example.androiddemoproject.webservices.okhttp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityOkhttpDemoBinding
import com.example.androiddemoproject.webservices.authretrofitrequests.adapter.ReqresUsersAdapter
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState

class OKHttpDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOkhttpDemoBinding
    private val viewModel by viewModels<OKHttpViewModel>()
    private val userAdapter by lazy { ReqresUsersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_okhttp_demo)
        binding.viewModel = viewModel
        setupRecyclerView()
        setupObservers()
        viewModel.getUsers()
    }

    private fun setupObservers() {
        viewModel.usersState.observe(this) { state ->
            binding.loadingIndicator.isGone = state !is UIState.Loading

            if (state is UIState.Success) {
                userAdapter.submitList(state.data)
            }
        }
        viewModel.userAddedState.observe(this) { state ->
            if (state is UIState.Success) {
                state.data?.let {
                    Toast.makeText(this, "Added ${it.firstName}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvPassengers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}