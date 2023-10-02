package com.example.giphysearch.domain.model.ApiService


import com.example.giphysearch.domain.model.TrendingNetworkResponse

interface ApiService {
    suspend fun getGlobalGifs(query:String):SafeResponse<TrendingNetworkResponse>
}