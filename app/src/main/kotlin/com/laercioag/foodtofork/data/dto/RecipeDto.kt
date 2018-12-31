package com.laercioag.foodtofork.data.dto

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("f2f_url")
    val f2fUrl: String = "",
    @SerializedName("image_url")
    val imageUrl: String = "",
    val publisher: String = "",
    @SerializedName("publisher_url")
    val publisherUrl: String = "",
    @SerializedName("recipe_id")
    val recipeId: String = "",
    @SerializedName("social_rank")
    val socialRank: Double = 0.0,
    @SerializedName("source_url")
    val sourceUrl: String = "",
    val title: String = ""
)
