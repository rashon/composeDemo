package com.example.composedemo.ui.fragment

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composedemo.ui.fragment.breedslist.BreedListVM
import com.example.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun BreedsListFragment(
    modifier: Modifier = Modifier,
    onListItemClick: (String) -> Unit = {},
    viewModel: BreedListVM = viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        BreedsListScreen(onListItemClick = onListItemClick, breedsList = viewModel.breedsList)
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BreedsListFragmentPreview() {
    ComposeDemoTheme {
        BreedsListFragment()
    }
}