package com.laercioag.foodtofork.data.remote

import com.laercioag.foodtofork.data.dto.SearchResultDto
import io.reactivex.Single
import javax.inject.Inject

class RecipeApi @Inject constructor(private val service: RemoteService) {

    fun search(): Single<SearchResultDto> = service.searchRecipes()
}
