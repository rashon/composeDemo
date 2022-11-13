package com.example.composedemo.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composedemo.R
import com.example.composedemo.navigation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var appBarArrowBackVisible = false
    var appBarTitle: String? = null

    when (navBackStackEntry?.destination?.route) {
        Destination.BreedDetails.route -> {
            appBarArrowBackVisible = true
            appBarTitle = Destination.BreedDetails.title
        }
        Destination.BreedsList.route -> {
            appBarArrowBackVisible = false
            appBarTitle = Destination.BreedsList.title
        }
    }

    TopAppBar(
        modifier = Modifier.shadow(dimensionResource(id = R.dimen.padding_default_quad)),
        title = {
            appBarTitle?.let {
                Text(text = it)
            }
        },
        navigationIcon = {
            if (appBarArrowBackVisible) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Outlined.ArrowBack, "Navigate Back")
                }
            }
        })
}