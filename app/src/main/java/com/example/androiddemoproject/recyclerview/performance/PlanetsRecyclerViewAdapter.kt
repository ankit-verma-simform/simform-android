package com.example.androiddemoproject.recyclerview.performance

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.PlanetListItemBinding
import com.example.androiddemoproject.recyclerview.listview.Planet

class PlanetsRecyclerViewAdapter(private val context: Context, private val planets: List<Planet>) :
    RecyclerView.Adapter<PlanetsRecyclerViewAdapter.ViewHolder>() {
    private var countOnCreateViewHolderMethodCalls = 0
    private var countGetItemCountMethodCalls = 0
    private var countOnBindViewHolderMethodCalls = 0

    inner class ViewHolder(val binding: PlanetListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlanetListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        Log.d("Performance", "onCreateViewHolder: called! ${++countOnCreateViewHolderMethodCalls}")
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("Performance", "getItemCount: called! ${++countGetItemCountMethodCalls}")
        return planets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgPlanet.setImageResource(planets[position].image)
        holder.binding.textPlanetName.text = planets[position].name
        Log.d("Performance", "onBindViewHolder: called! ${++countOnBindViewHolderMethodCalls}")
    }
}