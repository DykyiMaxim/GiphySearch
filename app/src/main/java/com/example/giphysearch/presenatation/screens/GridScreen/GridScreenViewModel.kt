package com.example.giphysearch.presenatation.screens.GridScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphysearch.data.GiphyApiService
import com.example.giphysearch.domain.model.ApiService.SafeResponse
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
    apiService: GiphyApiService
) : ViewModel() {

    private val _UiState = MutableStateFlow(GridScreenState())
    val uiSate: StateFlow<GridScreenState> = _UiState.asStateFlow()
    private val ApiService = apiService


    fun userSearch(query: String) {
        viewModelScope.launch {
            _UiState.value.isLoading = true
            _UiState.value.data = emptyList()
            val GifsResult = async(Dispatchers.Default) { ApiService.getGlobalGifs(query = query) }.await()
            when (GifsResult) {
                is SafeResponse.Success -> {
                    GifsResult.data?.let {
                        _UiState.value = GridScreenState(data = it.data, isLoading = false, error = "")

                    }
                }

                is SafeResponse.Error -> {
                    _UiState.value = GridScreenState(
                        isLoading = false,
                        error = GifsResult.message.toString()
                    )

                }

            }

        }
    }
}