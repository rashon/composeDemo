package com.example.composedemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composedemo.ui.fragment.breeddetails.BreedDetailsFragment
import com.example.composedemo.ui.fragment.breedlist.BreedListFragment

@Composable
fun FragmentContainerNavGraph(
    modifier: Modifier = Modifier, navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.BreedsList.route
    ) {
        composable(route = Destination.BreedsList.route) {
            BreedListFragment(onListItemClick = { breed ->
                navController.navigate(
                    route = Destination.BreedDetails.createRoute(breed)
                )
            })
        }
        composable(
            route = Destination.BreedDetails.route,
            arguments = listOf(navArgument(Arguments.DETAILS_ARGUMENT_BREED_ID) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val breedId = backStackEntry.arguments?.getString(Arguments.DETAILS_ARGUMENT_BREED_ID)
            requireNotNull(breedId) { "No data for such a breed" }
            BreedDetailsFragment(breedId = breedId)
        }
    }
}

object Arguments {
    const val DETAILS_ARGUMENT_BREED_ID = "breed_id"
    const val NAV_NAME = "nav_name"
}