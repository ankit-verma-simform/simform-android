package com.example.androiddemoproject.recyclerview.expandable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.MovieItemBinding

class MovieExpandableAdapter(val movies: List<Movie>) :
    RecyclerView.Adapter<MovieExpandableAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val movie = movies[adapterPosition]
                movie.isExpanded = !movie.isExpanded
                notifyItemChanged(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        with(holder.binding) {
            tvTitle.text = movie.title
            expandableLayout.visibility = if (movie.isExpanded) View.VISIBLE else View.GONE
            if (movie.isExpanded) {
                yearTextView.text = movie.year
                plotTextView.text = movie.plot
                ratingTextView.text = movie.rating
            }
        }
    }
}
