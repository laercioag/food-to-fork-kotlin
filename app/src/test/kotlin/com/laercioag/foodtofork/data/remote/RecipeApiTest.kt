package com.laercioag.foodtofork.data.remote

import com.laercioag.foodtofork.BuildConfig
import com.laercioag.foodtofork.util.TestUtils.Companion.getJson
import junit.framework.TestCase
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLEncoder

class RecipeApiTest {

    private lateinit var webServer: MockWebServer
    private lateinit var recipeApi: RecipeApi

    @Before
    fun before() {
        webServer = MockWebServer()
        webServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(webServer.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RemoteService::class.java)
        recipeApi = RecipeApi(service)
    }

    @Test
    fun `test when search returns a search result with recipes`() {
        val path = "/search?key=" + URLEncoder.encode(BuildConfig.API_KEY, "UTF-8")
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(getJson("json/recipes.json"))
        webServer.enqueue(mockResponse)
        recipeApi.search().test()
            .assertNoErrors()
            .assertValueCount(1)
        val request = webServer.takeRequest()
        TestCase.assertEquals(path, request.path)
    }

    @Test
    fun `test when search returns a search result with no recipes`() {
        val path = "/search?key=" + URLEncoder.encode(BuildConfig.API_KEY, "UTF-8")
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(getJson("json/empty_recipes.json"))
        webServer.enqueue(mockResponse)
        recipeApi.search().test()
            .assertNoErrors()
            .assertValueCount(1)
        val request = webServer.takeRequest()
        TestCase.assertEquals(path, request.path)
    }

    @Test
    fun `test when search fails`() {
        val path = "/search?key=" + URLEncoder.encode(BuildConfig.API_KEY, "UTF-8")
        val mockResponse = MockResponse()
            .setResponseCode(500)
        webServer.enqueue(mockResponse)
        recipeApi.search().test()
            .assertNoValues()
        val request = webServer.takeRequest()
        TestCase.assertEquals(path, request.path)
    }

    @After
    fun after() {
        webServer.shutdown()
    }

}
