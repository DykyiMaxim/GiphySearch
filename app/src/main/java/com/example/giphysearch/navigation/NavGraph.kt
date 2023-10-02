package com.example.giphysearch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.giphysearch.presenatation.screens.DetailScreen.DetailScreen
import com.example.giphysearch.presenatation.screens.GridScreen.GridScreen

@Composable
fun SetupNavGraph(
    startDestination: String,
    navController: NavHostController,

    ) {
    NavHost(navController = navController, startDestination) {
        GridScreenRout(
            NavigateToDetails = {
                navController.navigate(Screens.DeatilScreen.passUrl(it))
            },

            )
        DetailsScreenRout()

    }
}

fun NavGraphBuilder.GridScreenRout(
    NavigateToDetails: (String) -> Unit
) {
    composable(route = Screens.GridScreen.route) {

        GridScreen(onItemClicked = NavigateToDetails)

    }
}

fun NavGraphBuilder.DetailsScreenRout() {
    composable(
        route = Screens.DeatilScreen.route,
        arguments = listOf(navArgument("gifurl") {
            type = NavType.StringType
            defaultValue = ""
            nullable = false
        })
    ) {

        DetailScreen(url = it.arguments?.getString("gifurl"))
    }
}