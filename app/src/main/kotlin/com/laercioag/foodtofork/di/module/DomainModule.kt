package com.laercioag.foodtofork.di.module

import com.laercioag.foodtofork.data.repository.RecipeRepository
import com.laercioag.foodtofork.domain.mapper.RecipeDtoToRecipeMapper
import com.laercioag.foodtofork.domain.usecase.SearchRecipeUseCase
import com.laercioag.foodtofork.domain.usecase.impl.SearchRecipeUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesRecipeDtoToRecipeMapper(): RecipeDtoToRecipeMapper = RecipeDtoToRecipeMapper()

    @Provides
    fun providesSearchRecipeUseCase(
        repository: RecipeRepository,
        mapper: RecipeDtoToRecipeMapper
    ): SearchRecipeUseCase =
        SearchRecipeUseCaseImpl(repository, mapper)

}
