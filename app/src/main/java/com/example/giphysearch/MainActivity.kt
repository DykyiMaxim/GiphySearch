package com.example.giphysearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.giphysearch.navigation.Screens
import com.example.giphysearch.navigation.SetupNavGraph
import com.example.giphysearch.ui.theme.GiphySearchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiphySearchTheme {
                Surface {
                    val navController = rememberNavController()
                    SetupNavGraph(
                        startDestination = Screens.GridScreen.route,
                        navController = navController
                    )

                }
            }
        }
    }
}
