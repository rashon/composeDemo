package com.example.composedemo.navigation

sealed class Destination(val route: String, val title: String) {
    object MainActivityScreen : Destination("MainActivityScreen", "Welcome")
    object BreedsList : Destination("BreedsList", "Our Breeds")
    object BreedDetails : Destination("BreedDetails/{breed_id}", "Details") {
        fun createRoute(breedId: String) = "BreedDetails/$breedId"
    }
}