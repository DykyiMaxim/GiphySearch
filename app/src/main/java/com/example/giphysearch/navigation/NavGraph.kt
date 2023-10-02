package com.example.giphysearch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.giphysearch.presenatation.screens.detailScreen.DetailScreen
import com.example.giphysearch.presenatation.screens.gridScreen.GridScreen

@Composable
fun SetupNavGraph(
    startDestination: String,
    navController: NavHostController,

    ) {
    NavHost(navController = navController, startDestination) {
        gridScreenRout(
            navigateToDetails = {
                navController.navigate(Screens.DeatilScreen.passUrl(it))
            },

            )
        detailsScreenRout()

    }
}

fun NavGraphBuilder.gridScreenRout(
    navigateToDetails: (String) -> Unit
) {
    composable(route = Screens.GridScreen.route) {

        GridScreen(onItemClicked = navigateToDetails)

    }
}

fun NavGraphBuilder.detailsScreenRout() {
    composable(
        route = Screens.DeatilScreen.route,
        arguments = listOf(navArgument("gifUrl") {
            type = NavType.StringType
            defaultValue = ""
            nullable = false
        })
    ) {

        DetailScreen(url = it.arguments?.getString("gifUrl"))
    }
}