package com.example.composedemo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.navigation.Routes
import com.example.composedemo.ui.fragment.BreedsListFragment
import com.example.composedemo.ui.fragment.breeddetails.BreedDetailsFragment

@Composable
fun ComposeDemoNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.BreedsList.route) {
        composable(route = Routes.BreedsList.route) {
            BreedsListFragment(onListItemClick = {
                navController.navigate(
                    Routes.BreedDetails.route
                )
            }
            )
        }
        composable(route = Routes.BreedDetails.route) { BreedDetailsFragment() }
    }
}