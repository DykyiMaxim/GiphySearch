package com.example.giphysearch.navigation

sealed class Screens(val route:String) {
    object GridScreen:Screens(route = "Grid_Screen")
    object DeatilScreen:Screens(route = "Detail_Screen?gifUrl={gifUrl}"){
        fun passUrl(gifUrl:String) = "Detail_Screen?gifUrl=$gifUrl"
    }
}