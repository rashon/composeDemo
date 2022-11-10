package com.example.composedemo.domain.repository

import com.example.composedemo.api.ApiService
import com.example.composedemo.api.response.DetailsResponse
import com.example.composedemo.api.response.ImageResponse
import com.example.composedemo.api.response.MessageResponse
import com.example.composedemo.domain.service.BreedListService

class BreedsRepositoryImpl(
    private val apiService: ApiService,
    private val breedListService: BreedListService
) : BreedsRepository {
    override suspend fun getAllCachedBreeds(): MessageResponse =
        breedListService.breedList ?: getApiBreeds()


    override fun cacheBreeds(data: MessageResponse) {
        breedListService.breedList = data
    }

    override suspend fun getApiBreeds(): MessageResponse {
        val list = apiService.getBreedList()
        cacheBreeds(list)
        return list
    }

    override suspend fun getBreedImage(breed: String): ImageResponse =
        apiService.getImageUrl(breed)

    override suspend fun getBreedDetails(breed: String): DetailsResponse =
        apiService.getListOfImages(breed)

}