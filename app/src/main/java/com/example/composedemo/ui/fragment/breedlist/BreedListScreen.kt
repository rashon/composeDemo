package com.example.composedemo.ui.fragment.breedlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.R
import com.example.composedemo.domain.model.BreedModel
import com.example.composedemo.ui.components.BreedsListItem
import com.example.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun BreedsListScreen(
    modifier: Modifier = Modifier,
    onListItemClick: (String) -> Unit = {},
    breedList: List<BreedModel>? = null
) {
    if (breedList == null) return
    LazyVerticalGrid(
        modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_default)),
        columns = GridCells.Adaptive(minSize = dimensionResource(id = R.dimen.lazy_grid_column_min_size)),
    ) {
        items(breedList) { item ->
            BreedsListItem(item = item,
                modifier = modifier.fillMaxWidth(),
                onItemClick = { onListItemClick.invoke(item.name) })
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