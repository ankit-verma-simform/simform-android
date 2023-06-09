package com.example.androiddemoproject.recyclerview.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.AffirmationListItemBinding
import com.example.androiddemoproject.recyclerview.listviewviewholderpattern.Affirmation

class AffirmationRecyclerViewAdapter(
    val context: Context,
    private val affirmations: MutableList<Affirmation>,
    private val onAffirmationClicked: (affirmation: Affirmation, position: Int) -> Unit
) :
    RecyclerView.Adapter<AffirmationRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val binding: AffirmationListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AffirmationListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return affirmations.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgAffirmation.setImageResource(affirmations[position].image)
        holder.binding.tvAffirmation.setText(affirmations[position].quote)
        holder.binding.root.setOnClickListener {
            onAffirmationClicked(affirmations[position], position)
        }
    }
}