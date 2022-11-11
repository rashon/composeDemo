package com.example.composedemo.ui.fragment.breeddetails

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.R
import com.example.composedemo.ui.components.ErrorBox
import com.example.composedemo.ui.theme.ComposeDemoTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun BreedDetailsFragment(
    modifier: Modifier = Modifier,
    breedId: String,
    viewModel: BreedDetailsVM = koinViewModel()
) {

    viewModel.getBreedDetails(breedId)

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            if (viewModel.errorMessage.isEmpty()) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                        modifier = Modifier
                            .sizeIn(maxWidth = dimensionResource(id = R.dimen.progress_bar_size))
                            .align(Alignment.Center)
                    )
                } else {
                    BreedDetailsScreen(
                        breedId = breedId,
                        imageList = viewModel.imageList
                    )
                }
            } else {
                ErrorBox(message = viewModel.errorMessage)
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BreedDetailsFragmentPreview() {
    ComposeDemoTheme {
        BreedDetailsFragment(breedId = "test Breed")
    }
}