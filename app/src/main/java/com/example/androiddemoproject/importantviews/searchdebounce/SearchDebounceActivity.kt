package com.example.androiddemoproject.importantviews.searchdebounce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivitySearchDebounceBinding
import kotlinx.coroutines.launch

class SearchDebounceActivity : AppCompatActivity() {
    private val peopleAdapter by lazy { PeopleAdapter() }
    private lateinit var binding: ActivitySearchDebounceBinding
    private lateinit var viewModel: SearchDebounceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SearchDebounceViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_debounce)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setupPeopleRecyclerView()
        setupSearchView()
        observePeopleListChanges()
    }

    private fun observePeopleListChanges() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.people.collect {
                    peopleAdapter.submitList(it)
                }
            }
        }
    }

    private fun setupSearchView() {
        binding.searchPeople.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterPeople(query = newText)
                return true
            }
        })
    }

    private fun setupPeopleRecyclerView() {
        binding.rvPeople.apply {
            layoutManager = LinearLayoutManager(this@SearchDebounceActivity)
            adapter = peopleAdapter
        }
    }
}