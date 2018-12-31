package com.laercioag.foodtofork.data.dto

data class SearchResultDto(
    val count: Int = 0,
    val recipes: List<RecipeDto> = listOf()
)
