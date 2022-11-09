package com.example.composedemo.data.model

class BreedModel(
    val name: String,
    val imageUrls: List<String>? = listOf(),
    val subBreeds: List<String>? = listOf()
)