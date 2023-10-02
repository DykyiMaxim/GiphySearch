package com.example.giphysearch.data

import com.example.giphysearch.BuildConfig
import com.example.giphysearch.domain.model.TrendingNetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("search?")
    suspend fun getGlobalGifs(
        @Query("api_key") api_key:String=BuildConfig.GiphyAPiKey,
        @Query("q") q:String,
        @Query("limit") limit:String="25",
        @Query("offset") offset:String="0",
        @Query("rating") rating:String="g",
        @Query("lang") lang:String="en",
    ): Response<TrendingNetworkResponse>
}