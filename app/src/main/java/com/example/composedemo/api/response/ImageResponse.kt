package com.example.composedemo.api.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("message")
    val imageUrl: String
)
