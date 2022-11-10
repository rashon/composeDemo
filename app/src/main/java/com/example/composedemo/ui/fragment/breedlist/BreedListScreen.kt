package com.example.composedemo.ui.fragment.breedlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.components.BreedsListItem
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
                        .sizeIn(maxWidth = 56.dp)
                        .align(Alignment.Center)
                )
            } else {
                LazyVerticalGrid(
                    modifier = Modifier.padding(16.dp),
                    columns = GridCells.Adaptive(minSize = 152.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(viewModel.breedList) { item ->
                        BreedsListItem(item = item,
                            modifier = modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            onItemClick = { onListItemClick.invoke(item.name) })
                    }
                }
            }
        } else {
            Text(text = viewModel.errorMessage)
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