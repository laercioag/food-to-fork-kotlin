package com.laercioag.foodtofork.domain.usecase

import com.laercioag.foodtofork.domain.entity.Recipe
import com.laercioag.foodtofork.domain.usecase.base.BaseUseCase
import io.reactivex.Single

abstract class SearchRecipeUseCase : BaseUseCase<Single<List<Recipe>>>() {

    abstract override fun run(): Single<List<Recipe>>
}
