package com.example.composedemo.domain.repository

import com.example.composedemo.api.ApiService
import com.example.composedemo.api.response.ImageResponse
import com.example.composedemo.api.response.MessageResponse

class BreedsRepositoryImpl(private val apiService: ApiService) : BreedsRepository {

    override suspend fun getAllBreeds(): MessageResponse =
        apiService.getBreedList()

    override suspend fun getBreedImage(breed: String): ImageResponse =
        apiService.getImageByUrl(breed)
}