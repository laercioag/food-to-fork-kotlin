package com.laercioag.foodtofork.presentation.recipes

import com.laercioag.foodtofork.domain.entity.Recipe
import com.laercioag.foodtofork.domain.usecase.SearchRecipeUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipesPresenter @Inject constructor(private val searchRecipeUseCase: SearchRecipeUseCase) :
    RecipesContract.Presenter() {

    private var view: RecipesContract.View? = null

    override fun attach(view: RecipesContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
        super.detach()
    }

    override fun searchRecipes() {
        view?.showLoading()
        searchRecipeUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleSearchRecipesResult, this::handleError)
            .disposeOnDetach()
    }

    private fun handleSearchRecipesResult(items: List<Recipe>) {
        view?.hideLoading()
        view?.showRecipes(items)
    }

    private fun handleError(throwable: Throwable) {
        view?.hideLoading()
        view?.handleError(throwable)
    }
}
