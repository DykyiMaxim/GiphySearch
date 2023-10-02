package com.example.giphysearch.presenatation.screens.gridScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphysearch.data.GiphyApiService
import com.example.giphysearch.domain.model.apiService.SafeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GridScreenViewModel @Inject constructor(
    giphyApiService: GiphyApiService
) : ViewModel() {

    private val _uiState = MutableStateFlow(GridScreenState())
    val uiSate: StateFlow<GridScreenState> = _uiState.asStateFlow()
    private val apiService = giphyApiService


    fun userSearch(query: String) {
        viewModelScope.launch {
            _uiState.value.isLoading = true
            _uiState.value.data = emptyList()
            val gifsResult =
                async(Dispatchers.Default) { apiService.getGlobalGifs(query = query) }.await()
            when (gifsResult) {
                is SafeResponse.Success -> {
                    gifsResult.data?.let {
                        _uiState.value =
                            GridScreenState(data = it.data, isLoading = false, error = "")

                    }
                }

                is SafeResponse.Error -> {
                    _uiState.value = GridScreenState(
                        isLoading = false,
                        error = gifsResult.message.toString()
                    )

                }

            }

        }
    }
}