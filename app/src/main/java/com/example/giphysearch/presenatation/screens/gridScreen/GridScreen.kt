package com.example.giphysearch.presenatation.screens.gridScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.giphysearch.presenatation.components.GifFromUrl
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun GridScreen(
    viewModel: GridScreenViewModel = hiltViewModel(),
    onItemClicked: (String) -> Unit

) {
    val uistate by viewModel.uiSate.collectAsState()
    var userText by remember { mutableStateOf("") }
    var infoText by remember { mutableStateOf("Lets search for some gifs)") }


    Surface {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (uistate.isLoading) {
                CircularProgressIndicator()
            } else if (uistate.error.isNotEmpty()) {
                Text(text = uistate.error)
            }
        }


        if (!uistate.isLoading) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(60.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = userText,
                    onValueChange = { userText = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions {

                        viewModel.userSearch(userText)
                        infoText = "Cannot find gifs for this query"

                    }
                )
                Spacer(modifier = Modifier.width(32.dp))
                IconButton(onClick = {
                    viewModel.userSearch(userText)
                    infoText = "Cannot find gifs for this query"

                },
                    content = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                    })

            }
            Spacer(modifier = Modifier.height(20.dp))
            if (uistate.data.isNotEmpty()) {
                LazyVerticalGrid(
                    columns = GridCells.FixedSize(100.dp),
                    modifier = Modifier.padding(top = 100.dp),
                    content = {
                        items(uistate.data.size) { i ->
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable { onItemClicked(uistate.data[i].images.original.url) },
                                contentAlignment = Alignment.Center
                            ) {

                                GifFromUrl(model = uistate.data[i].images.fixed_height.url, 100)

                            }

                        }
                    })
            } else {
                Box(
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center

                ) {
                    Text(infoText)
                }
            }
        }


    }
}



