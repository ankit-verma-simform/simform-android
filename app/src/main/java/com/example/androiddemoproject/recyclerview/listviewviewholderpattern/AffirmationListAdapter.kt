package com.example.androiddemoproject.recyclerview.listviewviewholderpattern

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.androiddemoproject.databinding.AffirmationListItemBinding

class AffirmationListAdapter(
    private val activityContext: Context,
    private val affirmations: List<Affirmation>
) : ArrayAdapter<Affirmation>(activityContext, 0, affirmations) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: ViewHolder
        val view: View

        if (convertView == null) {
            // create new view holder 
            val binding = AffirmationListItemBinding.inflate(
                LayoutInflater.from(activityContext),
                parent,
                false
            )
            holder = ViewHolder(binding)
            view = binding.root
            view.setTag(holder)
        } else {
            // reuse existing view holder
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        // binding data to view
        holder.imgAffirmation.setImageResource(affirmations[position].image)
        holder.textQuoteAffirmation.setText(affirmations[position].quote)
        view.setOnClickListener {
            Toast.makeText(
                activityContext,
                "Clicked ${holder.textQuoteAffirmation.text}!",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }

    inner class ViewHolder(binding: AffirmationListItemBinding) {
        var imgAffirmation: ImageView = binding.imgAffirmation
        var textQuoteAffirmation: TextView = binding.tvAffirmation
    }
}