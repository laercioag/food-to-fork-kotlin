package com.laercioag.foodtofork.di.module

import com.laercioag.foodtofork.presentation.main.MainActivity
import com.laercioag.foodtofork.presentation.main.MainFragment
import com.laercioag.foodtofork.presentation.recipes.RecipesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun bindRecipesFragment(): RecipesFragment

}
