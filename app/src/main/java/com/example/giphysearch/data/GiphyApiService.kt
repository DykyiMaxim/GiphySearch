package com.example.giphysearch.data

import com.example.giphysearch.domain.model.ApiService.ApiService
import com.example.giphysearch.domain.model.ApiService.SafeResponse
import com.example.giphysearch.domain.model.TrendingNetworkResponse
import org.json.JSONObject
import javax.inject.Inject

class GiphyApiService @Inject constructor(
    val api: GiphyApi
) : ApiService {
    override suspend fun getGlobalGifs(query: String): SafeResponse<TrendingNetworkResponse> {
        val apiRequest = api.getGlobalGifs(q = query)
        if (apiRequest.errorBody() != null) {
            val jsonObj = JSONObject(apiRequest.errorBody()!!.charStream().readText())
            val errorMessage = jsonObj.getJSONObject("meta").getString("msg")
            return SafeResponse.Error(message = "error:${errorMessage}")
        }
        return SafeResponse.Success(apiRequest.body())
    }
}
