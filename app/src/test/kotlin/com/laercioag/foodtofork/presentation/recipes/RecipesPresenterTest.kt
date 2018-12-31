package com.laercioag.foodtofork.presentation.recipes

import com.laercioag.foodtofork.domain.usecase.SearchRecipeUseCase
import com.laercioag.foodtofork.util.TestUtils.Companion.getListOfFakeRecipe
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class RecipesPresenterTest {

    private lateinit var searchRecipeUseCase: SearchRecipeUseCase
    private lateinit var view: RecipesContract.View
    private lateinit var presenter: RecipesContract.Presenter

    @Before
    fun before() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        searchRecipeUseCase = mock(SearchRecipeUseCase::class.java)
        view = mock(RecipesContract.View::class.java)
        presenter = RecipesPresenter(searchRecipeUseCase)
        presenter.attach(view)
    }

    @Test
    fun `test when search recipes returns a list of recipes`() {
        val recipes = getListOfFakeRecipe()
        `when`(searchRecipeUseCase()).thenReturn(Single.just(recipes))
        presenter.searchRecipes()
        verify(view, times(1)).showLoading()
        verify(view, times(1)).hideLoading()
        verify(view, times(1)).showRecipes(recipes)
    }

    @Test
    fun `test when search recipes returns an error`() {
        val error = RuntimeException()
        `when`(searchRecipeUseCase()).thenReturn(Single.error(error))
        presenter.searchRecipes()
        verify(view, times(1)).showLoading()
        verify(view, times(1)).hideLoading()
        verify(view, times(1)).handleError(error)
    }

}
