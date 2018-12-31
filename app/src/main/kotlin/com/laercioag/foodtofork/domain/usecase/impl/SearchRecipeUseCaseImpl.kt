package com.laercioag.foodtofork.domain.usecase.impl

import com.laercioag.foodtofork.data.repository.RecipeRepository
import com.laercioag.foodtofork.domain.entity.Recipe
import com.laercioag.foodtofork.domain.mapper.RecipeDtoToRecipeMapper
import com.laercioag.foodtofork.domain.usecase.SearchRecipeUseCase
import io.reactivex.Single
import javax.inject.Inject

class SearchRecipeUseCaseImpl @Inject constructor(
    private val repository: RecipeRepository,
    private val mapper: RecipeDtoToRecipeMapper
) : SearchRecipeUseCase() {

    override fun run(): Single<List<Recipe>> {
        return repository.search()
            .map { mapper.mapList(it.recipes) }
    }

}
