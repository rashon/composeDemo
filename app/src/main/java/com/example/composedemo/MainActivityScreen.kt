package com.example.composedemo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.navigation.FragmentContainerNavGraph
import com.example.composedemo.ui.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityScreen(modifier: Modifier = Modifier) {

    val fragmentContainerNavController = rememberNavController()

    Scaffold(modifier = modifier, topBar = { CustomTopAppBar(fragmentContainerNavController) },
        content = { containerPadding ->
            FragmentContainerNavGraph(
                modifier = Modifier.padding(containerPadding),
                navController = fragmentContainerNavController
            )
        })
}