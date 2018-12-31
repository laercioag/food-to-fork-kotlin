package com.laercioag.foodtofork.data.repository

import com.laercioag.foodtofork.data.remote.RecipeApi
import com.laercioag.foodtofork.data.repository.impl.RecipeRepositoryImpl
import com.laercioag.foodtofork.util.TestUtils.Companion.getFakeSearchResultDto
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class RecipeRepositoryImplTest {

    private lateinit var recipeApi: RecipeApi
    private lateinit var recipeRepository: RecipeRepository

    @Before
    fun before() {
        recipeApi = mock(RecipeApi::class.java)
        recipeRepository = RecipeRepositoryImpl(recipeApi)
    }

    @Test
    fun `test when search returns a search result with recipes`() {
        val searchResult = getFakeSearchResultDto()
        `when`(recipeApi.search()).thenReturn(Single.just(searchResult))
        recipeRepository.search().test()
            .assertNoErrors()
            .assertValueCount(1)
            .assertValue { result -> result == searchResult }
            .assertValue(searchResult)
    }

    @Test
    fun `test when search fails`() {
        `when`(recipeApi.search()).thenReturn(Single.error(RuntimeException()))
        recipeRepository.search().test()
            .assertError(RuntimeException::class.java)
            .assertValueCount(0)
    }

}
