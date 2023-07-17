package com.example.androiddemoproject.permissions

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.PermissionsMainNavButtonItemBinding

class PermissionsAdapter(
    val navigationItems: List<PermissionsMainNavigation>
) :
    RecyclerView.Adapter<PermissionsAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: PermissionsMainNavButtonItemBinding) :
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
        val binding = DataBindingUtil.inflate<PermissionsMainNavButtonItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.permissions_main_nav_button_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = navigationItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}