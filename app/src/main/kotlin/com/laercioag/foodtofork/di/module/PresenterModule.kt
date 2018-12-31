package com.laercioag.foodtofork.di.module

import com.laercioag.foodtofork.presentation.recipes.RecipesContract
import com.laercioag.foodtofork.presentation.recipes.RecipesPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModule {

    @Binds
    abstract fun bindRecipesPresenter(recipesPresenter: RecipesPresenter): RecipesContract.Presenter

}
