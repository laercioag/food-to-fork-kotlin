package com.laercioag.foodtofork.util

import com.laercioag.foodtofork.data.dto.RecipeDto
import com.laercioag.foodtofork.data.dto.SearchResultDto
import com.laercioag.foodtofork.domain.entity.Recipe
import java.io.File

class TestUtils {

    companion object {

        fun getFakeRecipeDto(): RecipeDto =
            RecipeDto(
                f2fUrl = "www.fakeurl.com",
                imageUrl = "www.fakeurl.com/image",
                publisher = "Fake Publisher",
                publisherUrl = "www.fakepublisher.com",
                recipeId = "FAKE_ID",
                socialRank = 100.0,
                sourceUrl = "www.fakesource.com",
                title = "Fake Recipe"
            )

        fun getListOfFakeRecipeDto(): List<RecipeDto> = (0..30).map { getFakeRecipeDto() }

        fun getFakeSearchResultDto(): SearchResultDto =
            SearchResultDto(
                count = 30,
                recipes = getListOfFakeRecipeDto()
            )

        fun getFakeRecipe(): Recipe =
            Recipe(
                f2fUrl = "www.fakeurl.com",
                imageUrl = "www.fakeurl.com/image",
                publisher = "Fake Publisher",
                publisherUrl = "www.fakepublisher.com",
                recipeId = "FAKE_ID",
                socialRank = 100.0,
                sourceUrl = "www.fakesource.com",
                title = "Fake Recipe"
            )

        fun getListOfFakeRecipe(): List<Recipe> = (0..30).map { getFakeRecipe() }

        fun getJson(path: String): String {
            val uri = this::class.java.classLoader!!.getResource(path)
            val file = File(uri.path)
            return String(file.readBytes())
        }

    }

}
