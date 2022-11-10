package com.example.composedemo.domain.repository

import com.example.composedemo.api.response.ImageResponse
import com.example.composedemo.api.response.MessageResponse

interface BreedsRepository {
    suspend fun getAllBreeds(): MessageResponse
    suspend fun getBreedImage(breed: String): ImageResponse
}