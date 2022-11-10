package com.example.composedemo.api.response

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("message")
    val message: Map<String, List<String>>
)
