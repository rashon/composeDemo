package com.example.composedemo.ui.fragment

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.data.model.BreedModel
import com.example.composedemo.ui.components.BreedsListItem
import com.example.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun BreedsListScreen(
    modifier: Modifier = Modifier,
    onListItemClick: (String) -> Unit = {},
    breedsList: List<BreedModel>
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(16.dp),
        columns = GridCells.Adaptive(160.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = breedsList, key = { breed -> breed.name }) {
            BreedsListItem(
                item = it,
                modifier = modifier.padding(16.dp),
                onItemClick = { onListItemClick.invoke(it.name) }
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ItemsScreenPreview() {
    ComposeDemoTheme {
        BreedsListScreen(breedsList = listOf(BreedModel("item1"), BreedModel("item2")))
    }
}