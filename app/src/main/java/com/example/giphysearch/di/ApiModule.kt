package com.example.giphysearch.di

import com.example.giphysearch.data.GiphyApiService
import com.example.giphysearch.domain.model.apiService.ApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {
    @Binds
    @Singleton
    abstract fun bindGiphyApiService(
        apiService: GiphyApiService
    ):ApiService
}