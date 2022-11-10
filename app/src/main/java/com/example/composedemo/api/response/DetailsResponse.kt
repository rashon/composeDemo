package com.example.composedemo.api.response

import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    @SerializedName("message")
    val listOfImages: List<String>
)