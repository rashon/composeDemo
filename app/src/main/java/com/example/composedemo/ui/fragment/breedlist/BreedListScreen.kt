package com.example.composedemo.ui.fragment.breedlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.R
import com.example.composedemo.ui.components.BreedsListItem
import com.example.composedemo.ui.components.ErrorBox
import com.example.composedemo.ui.theme.ComposeDemoTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun BreedsListScreen(
    modifier: Modifier = Modifier,
    onListItemClick: (String) -> Unit = {},
    viewModel: BreedListVM = koinViewModel()
) {

    LaunchedEffect(Unit, block = {
        viewModel.getBreedList()
    })

    Box {
        if (viewModel.errorMessage.isEmpty()) {

            if (viewModel.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                    modifier = Modifier
                        .sizeIn(maxWidth = dimensionResource(R.dimen.progress_bar_size))
                        .align(Alignment.Center)
                )
            } else {
                LazyVerticalGrid(
                    modifier = modifier,
                    columns = GridCells.Adaptive(minSize = dimensionResource(id = R.dimen.lazy_grid_column_min_size)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_default_double)),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_default_double))
                ) {
                    items(viewModel.breedList) { item ->
                        BreedsListItem(item = item,
                            modifier = modifier.fillMaxWidth(),
                            onItemClick = { onListItemClick.invoke(item.name) })
                    }
                }
            }
        } else {
            ErrorBox(message = viewModel.errorMessage)
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ItemsScreenPreview() {
    ComposeDemoTheme {
        BreedsListScreen()
    }
}