package com.example.androiddemoproject.importantviews

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ImportantViewsNavButtonItemBinding

class ImportantViewsAdapter(
    val context: Context,
    val navigationItems: List<ImportantViewsNavigationItem>
) :
    RecyclerView.Adapter<ImportantViewsAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ImportantViewsNavButtonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnNavigation.setOnClickListener {
                Intent(context, navigationItems[adapterPosition].activity).also {
                    context.startActivity(it)
                }
            }
        }

        fun bind(position: Int) {
            binding.btnNavigation.text = navigationItems[position].label
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ImportantViewsNavButtonItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.important_views_nav_button_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = navigationItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}
