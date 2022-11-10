package com.example.composedemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composedemo.navigation.Routes
import com.example.composedemo.ui.fragment.breeddetails.BreedDetailsFragment
import com.example.composedemo.ui.fragment.breedlist.BreedListFragment

@Composable
fun ComposeDemoNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.BreedsList.route) {
        composable(route = Routes.BreedsList.route) {
            BreedListFragment(onListItemClick = { breed ->
                navController.navigate(
                    Routes.BreedDetails.createRoute(breed)
                )
            }
            )
        }
        composable(route = Routes.BreedDetails.route, arguments = listOf(
            navArgument(Arguments.DETAILS_ARGUMENT_BREED_ID) {
                type = NavType.StringType
            }
        )) { backStackEntry ->
            val breedId = backStackEntry.arguments?.getString(Arguments.DETAILS_ARGUMENT_BREED_ID)
            requireNotNull(breedId) { "No data for such a breed" }
            BreedDetailsFragment(breedId = breedId)
        }
    }
}

object Arguments {
    const val DETAILS_ARGUMENT_BREED_ID = "breed_id"
}