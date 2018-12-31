package com.laercioag.foodtofork.domain.entity

data class Recipe(
    val f2fUrl: String = "",
    val imageUrl: String = "",
    val publisher: String = "",
    val publisherUrl: String = "",
    val recipeId: String = "",
    val socialRank: Double = 0.0,
    val sourceUrl: String = "",
    val title: String = ""
)
