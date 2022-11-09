package com.example.composedemo.navigation

sealed class Routes(val route: String) {
    object BreedsList : Routes("BreedsList")
    object BreedDetails : Routes("BreedDetails/{breed_id}") {
        fun createRoute(breedId: String) = "BreedDetails/$breedId"
    }
}