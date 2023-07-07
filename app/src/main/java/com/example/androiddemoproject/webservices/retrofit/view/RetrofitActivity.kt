package com.example.androiddemoproject.webservices.retrofit.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityRetrofitBinding
import com.example.androiddemoproject.webservices.retrofit.adapter.TodoAdapter
import com.example.androiddemoproject.webservices.retrofit.viewmodel.TodoRetrofitViewModel

class RetrofitActivity : AppCompatActivity() {
    private val viewModel by viewModels<TodoRetrofitViewModel>()
    private lateinit var binding: ActivityRetrofitBinding
    private val todoAdapter by lazy { TodoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)
        setupRecyclerView()
        viewModel.getTodos()
        setObservers()
    }

    private fun setupRecyclerView() {
        with(binding.rvTodos) {
            layoutManager = LinearLayoutManager(this@RetrofitActivity)
            adapter = todoAdapter
        }
    }

    private fun setObservers() {
        viewModel.loading.observe(this) {
            binding.progressBar.isGone = !it
        }
        viewModel.todos.observe(this) {
            todoAdapter.submitList(it)
        }
    }
}