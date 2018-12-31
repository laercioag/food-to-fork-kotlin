package com.laercioag.foodtofork.data.repository.impl

import com.laercioag.foodtofork.data.dto.SearchResultDto
import com.laercioag.foodtofork.data.remote.RecipeApi
import com.laercioag.foodtofork.data.repository.RecipeRepository
import io.reactivex.Single
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val recipeApi: RecipeApi) : RecipeRepository {

    override fun search(): Single<SearchResultDto> = recipeApi.search()
}
