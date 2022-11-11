package com.example.composedemo.ui.fragment.breedlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun BreedListFragment(
    modifier: Modifier = Modifier, onListItemClick: (String) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        BreedsListScreen(
            onListItemClick = onListItemClick, modifier = modifier.padding(
                dimensionResource(id = R.dimen.padding_default_double)
            )
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BreedsListFragmentPreview() {
    ComposeDemoTheme {
        BreedListFragment()
    }
}