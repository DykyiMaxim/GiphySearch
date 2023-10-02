package com.example.giphysearch.presenatation.screens.GridScreen

import com.example.giphysearch.domain.model.TrendingData

data class GridScreenState(
    var data:List<TrendingData> = emptyList(),
    var isLoading:Boolean = false,
    var error:String = ""
)