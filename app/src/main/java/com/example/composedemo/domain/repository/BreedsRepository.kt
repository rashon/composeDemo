package com.example.composedemo.domain.repository

import com.example.composedemo.api.response.DetailsResponse
import com.example.composedemo.api.response.ImageResponse
import com.example.composedemo.api.response.MessageResponse

interface BreedsRepository {
    suspend fun getAllCachedBreeds(): MessageResponse?
    fun cacheBreeds(data: MessageResponse)
    suspend fun getApiBreeds(): MessageResponse
    suspend fun getBreedImage(breed: String): ImageResponse
    suspend fun getBreedDetails(breed: String): DetailsResponse
}