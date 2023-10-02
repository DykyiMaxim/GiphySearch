package com.example.giphysearch.navigation

sealed class Screens(val route:String) {
    object GridScreen:Screens(route = "Grid_Screen")
    object DeatilScreen:Screens(route = "Detail_Screen?gifurl={gifurl}"){
        fun passUrl(gifurl:String) = "Detail_Screen?gifurl=$gifurl"
    }
}