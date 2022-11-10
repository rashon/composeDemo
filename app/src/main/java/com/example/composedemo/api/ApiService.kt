package com.example.composedemo.api

import com.example.composedemo.api.response.DetailsResponse
import com.example.composedemo.api.response.ImageResponse
import com.example.composedemo.api.response.MessageResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("breeds/list/all")
    suspend fun getBreedList(): MessageResponse

    @GET("breed/{breedName}/images/random")
    suspend fun getImageUrl(@Path("breedName") breedName: String): ImageResponse

    @GET("breed/{breedName}/images/random/7")
    suspend fun getListOfImages(@Path("breedName") breedName: String): DetailsResponse

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService? {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService
        }
    }
}

const val BASE_URL = "https://dog.ceo/api/"
