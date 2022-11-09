package com.example.composedemo.ui.fragment.breedslist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composedemo.data.model.BreedModel

class BreedListVM : ViewModel() {
    val breedsList = mutableStateListOf(
        BreedModel("Breed1"),
        BreedModel("Breed2"),
        BreedModel("Breed3"),
        BreedModel("Breed4"),
        BreedModel("Breed5"),
        BreedModel("Breed6"),
        BreedModel("Breed7"),
        BreedModel("Breed8"),
        BreedModel("Breed9"),
        BreedModel("Breed10"),
        BreedModel("Breed11"),
        BreedModel("Breed12")
    )
}