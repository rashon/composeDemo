package com.example.composedemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.MainActivityScreen

@Composable
fun MainActivityNavGraph(
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.MainActivityScreen.route
    ) {
        composable(Destination.MainActivityScreen.route) {
            MainActivityScreen()
        }
    }
}