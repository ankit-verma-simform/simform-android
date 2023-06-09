package com.example.androiddemoproject.recyclerview.viewpager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.FoodItemBinding

class FoodViewPager2Adapter : RecyclerView.Adapter<FoodViewPager2Adapter.ViewHolder>() {
    private val foodList = getFoodItems()

    inner class ViewHolder(val binding: FoodItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgFood.setImageResource(foodList[position].image)
    }
}