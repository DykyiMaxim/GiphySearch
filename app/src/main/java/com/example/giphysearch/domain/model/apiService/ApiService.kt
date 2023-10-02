package com.example.giphysearch.domain.model.apiService


import com.example.giphysearch.domain.model.TrendingNetworkResponse

interface ApiService {
    suspend fun getGlobalGifs(query:String):SafeResponse<TrendingNetworkResponse>
}