package com.example.composedemo.ui.fragment

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
        columns = GridCells.Adaptive(minSize = 152.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(
            items = breedsList,
            key = { _, breed -> breed.breedId }) { _, item ->
            BreedsListItem(item = item,
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onItemClick = { onListItemClick.invoke(item.name) })
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ItemsScreenPreview() {
    ComposeDemoTheme {
        BreedsListScreen(breedsList = listOf(BreedModel(0, "item1"), BreedModel(1, "item2")))
    }
}