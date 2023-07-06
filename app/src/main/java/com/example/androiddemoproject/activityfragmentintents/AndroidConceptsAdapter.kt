package com.example.androiddemoproject.activityfragmentintents

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.AndroidConceptNavButtonItemBinding

class AndroidConceptsAdapter: RecyclerView.Adapter<AndroidConceptsAdapter.ViewHolder>() {
    private val navList = getAndroidConceptsNavigationItems()

    inner class ViewHolder(val binding: AndroidConceptNavButtonItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = navList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AndroidConceptNavButtonItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding.btnNavigation) {
            val navItem = navList[position]
            text = navItem.label
            setOnClickListener {
                Intent(context, navItem.activity).run {
                    context.startActivity(this)
                }
            }
        }
    }
}