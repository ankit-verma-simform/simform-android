package com.example.androiddemoproject.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.RecyclerViewAllListingItemBinding

class RecyclerViewNavigationAdapter(
    private val context: Context,
    private val list: List<NavigationActivityItem>
) : RecyclerView.Adapter<RecyclerViewNavigationAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RecyclerViewAllListingItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerViewAllListingItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            btnNavigation.text = list[position].label ?: list[position].activity.simpleName
            btnNavigation.setOnClickListener {
                Intent(context, list[position].activity).also {
                    context.startActivity(it)
                }
            }
        }
    }
}