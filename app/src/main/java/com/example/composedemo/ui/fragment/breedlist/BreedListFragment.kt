package com.example.composedemo.ui.fragment.breedlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.ui.components.ErrorBox
import com.example.composedemo.ui.theme.ComposeDemoTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun BreedListFragment(
    modifier: Modifier = Modifier.fillMaxSize(),
    onListItemClick: (String) -> Unit = {},
    viewModel: BreedListVM = koinViewModel()
) {
    Surface(
        modifier = modifier, color = MaterialTheme.colorScheme.background
    ) {
        if (viewModel.errorMessage.isEmpty()) {
            if (viewModel.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                    modifier = Modifier
                        .wrapContentSize()
                )
            } else {
                if (viewModel.breedList.isNotEmpty()) {
                    BreedsListScreen(
                        onListItemClick = onListItemClick,
                        modifier = modifier,
                        breedList = viewModel.breedList
                    )
                }
            }
        } else {
            ErrorBox(
                message = viewModel.errorMessage,
                modifier = Modifier.wrapContentSize()
            )
        }

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