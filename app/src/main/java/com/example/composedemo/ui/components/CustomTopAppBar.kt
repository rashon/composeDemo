package com.example.composedemo.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composedemo.R
import com.example.composedemo.navigation.Destination

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun CustomTopAppBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var appBarArrowBackVisible by remember {
        mutableStateOf(false)
    }
    var appBarTitle by remember {
        mutableStateOf("")
    }

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
    val animationTime = 600
    val animationDelayTime = 5

    val arrowStartLocation = Offset(0F, 0F)
    val arrowEndLocation = Offset(-50F, 0F)

    val arrowLocation by animateOffsetAsState(
        targetValue = if (appBarArrowBackVisible) arrowStartLocation else arrowEndLocation,
        animationSpec = tween(animationTime, animationDelayTime, easing = LinearOutSlowInEasing)
    )

    TopAppBar(modifier = Modifier.shadow(dimensionResource(id = R.dimen.padding_default_quad)),
        title = {
            AnimatedContent(
                targetState = appBarTitle,
                transitionSpec = {
                    fadeIn() with fadeOut()
                }) {
                Text(
                    text = appBarTitle
                )
            }
        },
        navigationIcon = {
            AnimatedVisibility(
                visible = appBarArrowBackVisible, enter = fadeIn(), exit = fadeOut()
            ) {
                IconButton(
                    modifier = Modifier.offset(arrowLocation.x.dp, arrowLocation.y.dp),
                    onClick = { navController.navigateUp() }) {
                    Icon(Icons.Outlined.ArrowBack, "Navigate Back")
                }
            }
        })
}