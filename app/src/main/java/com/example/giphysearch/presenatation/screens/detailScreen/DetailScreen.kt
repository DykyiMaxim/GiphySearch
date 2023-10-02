package com.example.giphysearch.presenatation.screens.detailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.giphysearch.data.ConnectionState
import com.example.giphysearch.presenatation.components.GifFromUrl
import com.example.giphysearch.presenatation.screens.gridScreen.connectivityState
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun DetailScreen(url: String?) {
    val connection by connectivityState()
    val isConnected = connection === ConnectionState.Available

    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (url != null&&isConnected) {
                GifFromUrl(model = url, size = 1000)
            }else{
                Text(text = "Turn on your internet to load gif")
            }
        }
    }
}


