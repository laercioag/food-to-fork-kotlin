package com.laercioag.foodtofork.domain.usecase

import com.laercioag.foodtofork.data.repository.RecipeRepository
import com.laercioag.foodtofork.domain.mapper.RecipeDtoToRecipeMapper
import com.laercioag.foodtofork.domain.usecase.impl.SearchRecipeUseCaseImpl
import com.laercioag.foodtofork.util.TestUtils
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class SearchRecipeUseCaseImplTest {

    private lateinit var recipeRepository: RecipeRepository
    private lateinit var recipeDtoToRecipeMapper: RecipeDtoToRecipeMapper
    private lateinit var searchRecipeUseCase: SearchRecipeUseCaseImpl

    @Before
    fun before() {
        recipeRepository = mock(RecipeRepository::class.java)
        recipeDtoToRecipeMapper = RecipeDtoToRecipeMapper()
        searchRecipeUseCase = SearchRecipeUseCaseImpl(
            recipeRepository,
            recipeDtoToRecipeMapper
        )
    }

    @Test
    fun `test when search recipe use case returns a list of recipes`() {
        val searchResult = TestUtils.getFakeSearchResultDto()
        val recipes = recipeDtoToRecipeMapper.mapList(searchResult.recipes)
        `when`(recipeRepository.search()).thenReturn(Single.just(searchResult))
        searchRecipeUseCase().test()
            .assertNoErrors()
            .assertValueCount(1)
            .assertValue(recipes)
    }

    @Test
    fun `test when search recipe use case fails`() {
        `when`(recipeRepository.search()).thenReturn(Single.error(RuntimeException()))
        searchRecipeUseCase().test()
            .assertError(RuntimeException::class.java)
            .assertValueCount(0)
    }

}
