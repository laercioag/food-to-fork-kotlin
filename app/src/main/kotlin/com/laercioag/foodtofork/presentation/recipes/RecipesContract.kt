package com.laercioag.foodtofork.presentation.recipes

import com.laercioag.foodtofork.domain.entity.Recipe
import com.laercioag.foodtofork.presentation.base.BasePresenter
import com.laercioag.foodtofork.presentation.base.BaseView

class RecipesContract {

    interface View : BaseView {
        fun showRecipes(items: List<Recipe>)
    }

    abstract class Presenter : BasePresenter<RecipesContract.View>() {
        abstract fun searchRecipes()
    }
}
