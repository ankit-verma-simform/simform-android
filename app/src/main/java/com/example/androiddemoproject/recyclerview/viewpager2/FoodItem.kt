package com.example.androiddemoproject.recyclerview.viewpager2

import androidx.annotation.DrawableRes
import com.example.androiddemoproject.R

data class FoodItem(@DrawableRes val image: Int)

fun getFoodItems() = listOf(
    FoodItem(image = R.drawable.food1),
    FoodItem(image = R.drawable.food2),
    FoodItem(image = R.drawable.food3),
    FoodItem(image = R.drawable.food4),
    FoodItem(image = R.drawable.food5),
)