package com.example.giphysearch.domain.model.ApiService

sealed class SafeResponse<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): SafeResponse<T>(data)
    class Error<T>(message: String, data: T? = null): SafeResponse<T>(data, message)
}