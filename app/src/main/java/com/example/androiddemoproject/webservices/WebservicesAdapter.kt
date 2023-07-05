package com.example.androiddemoproject.webservices

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.WebservicesMainNavButtonItemBinding

class WebservicesAdapter(
    val navigationItems: List<WebservicesMainNavigation>
) :
    RecyclerView.Adapter<WebservicesAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: WebservicesMainNavButtonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnNavigation.setOnClickListener {
                Intent(binding.root.context, navigationItems[adapterPosition].activity).also {
                    binding.root.context.startActivity(it)
                }
            }
        }

        fun bind(position: Int) {
            binding.btnNavigation.text = navigationItems[position].label
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<WebservicesMainNavButtonItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.webservices_main_nav_button_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = navigationItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}