package com.example.androiddemoproject.recyclerview.listview

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.androiddemoproject.databinding.PlanetListItemBinding

class PlanetsArrayAdapter(
    private val activityContext: Context,
    private val planets: List<Planet>
) :
    ArrayAdapter<Planet>(activityContext, 0, planets) {
    private lateinit var binding: PlanetListItemBinding
    private var countGetViewMethodCalls = 0

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (convertView != null) return convertView
        binding = PlanetListItemBinding.inflate(
            LayoutInflater.from(activityContext), parent, false
        )
        binding.imgPlanet.setImageResource(planets[position].image)
        binding.textPlanetName.text = planets[position].name
        Log.d("Performance", "getView: called! ${++countGetViewMethodCalls}")
        return binding.root
    }
}