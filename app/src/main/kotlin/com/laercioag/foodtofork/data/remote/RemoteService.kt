package com.laercioag.foodtofork.data.remote

import com.laercioag.foodtofork.BuildConfig
import com.laercioag.foodtofork.data.dto.SearchResultDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("search")
    fun searchRecipes(@Query("key") key: String = BuildConfig.API_KEY): Single<SearchResultDto>

}
