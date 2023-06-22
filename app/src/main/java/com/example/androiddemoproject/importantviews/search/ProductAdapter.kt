package com.example.androiddemoproject.importantviews.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ProductItemBinding

class ProductAdapter :
    ListAdapter<Product, ProductAdapter.ViewHolder>(ProductDiffUtils()) {
    inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "${getItem(adapterPosition)} clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        fun bind(position: Int) {
            binding.product = getItem(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ProductItemBinding>(
            LayoutInflater.from(parent.context), R.layout.product_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    class ProductDiffUtils : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
