package com.laercioag.foodtofork.domain.mapper

import com.laercioag.foodtofork.data.dto.RecipeDto
import com.laercioag.foodtofork.domain.entity.Recipe
import com.laercioag.foodtofork.domain.mapper.base.Mapper

class RecipeDtoToRecipeMapper : Mapper<RecipeDto, Recipe> {

    override fun map(param: RecipeDto): Recipe = with(param) {
        Recipe(f2fUrl, imageUrl, publisher, publisherUrl, recipeId, socialRank, sourceUrl, title)
    }

    override fun mapReverse(param: Recipe): RecipeDto = with(param) {
        RecipeDto(f2fUrl, imageUrl, publisher, publisherUrl, recipeId, socialRank, sourceUrl, title)
    }

}
