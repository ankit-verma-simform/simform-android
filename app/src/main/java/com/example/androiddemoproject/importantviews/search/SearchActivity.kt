package com.example.androiddemoproject.importantviews.search

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val productsAdapter by lazy { ProductAdapter().also { it.submitList(getProducts()) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        setupProductsRecyclerView()
    }

    private fun setupProductsRecyclerView() {
        binding.rvProducts.apply {
            adapter = productsAdapter
            layoutManager = GridLayoutManager(
                this@SearchActivity, 2, GridLayoutManager.VERTICAL, false
            )
            addItemDecoration(ProductItemDecoration())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        setupSearch(menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupSearch(menu: Menu?) {
        val searchMenuItem = menu?.findItem(R.id.search)
        val searchView = searchMenuItem?.actionView as? SearchView
        searchView?.apply {
            queryHint = """Search a "product""""
            setOnQueryTextListener(object : OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrEmpty()) {
                        productsAdapter.submitList(getProducts())
                        return false
                    }
                    val filterList = getProducts().filter { product ->
                        product.isAMatchOf(newText)
                    }
                    productsAdapter.submitList(filterList)
                    return true
                }
            })
        }
    }
}