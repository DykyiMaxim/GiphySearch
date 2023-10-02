package com.example.giphysearch.di

import com.example.giphysearch.data.GiphyApiService
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
        ApiService: GiphyApiService
    ): GiphyApiService
}