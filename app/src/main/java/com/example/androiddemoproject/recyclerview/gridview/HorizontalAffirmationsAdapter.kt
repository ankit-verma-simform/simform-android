package com.example.androiddemoproject.recyclerview.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.HorizontalAffirmationListItemBinding
import com.example.androiddemoproject.recyclerview.listviewviewholderpattern.Affirmation

class HorizontalAffirmationsAdapter(
    val context: Context,
    private val affirmations: MutableList<Affirmation>,
    private val onAffirmationsDeleted: () -> Unit,
) : RecyclerView.Adapter<HorizontalAffirmationsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: HorizontalAffirmationListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(affirmation: Affirmation) {
            with(binding) {
                imgAffirmation.setImageResource(affirmation.image)
                tvAffirmation.setText(affirmation.quote)
                root.setOnClickListener {
                    Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
                }
                imgDeleteAffirmation.setOnClickListener {
                    affirmations.remove(affirmation)
                    onAffirmationsDeleted()
                    notifyItemRemoved(adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HorizontalAffirmationListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return affirmations.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(affirmations[position])
    }
}