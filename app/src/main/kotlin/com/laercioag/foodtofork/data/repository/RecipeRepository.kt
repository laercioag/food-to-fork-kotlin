package com.laercioag.foodtofork.data.repository

import com.laercioag.foodtofork.data.dto.SearchResultDto
import io.reactivex.Single

interface RecipeRepository {

    fun search(): Single<SearchResultDto>
}
