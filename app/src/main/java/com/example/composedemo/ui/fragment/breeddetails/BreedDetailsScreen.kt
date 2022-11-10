package com.example.composedemo.ui.fragment.breeddetails

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.composedemo.R
import com.example.composedemo.ui.components.ErrorBox
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BreedDetailsScreen(
    modifier: Modifier = Modifier, breedId: String, viewModel: BreedDetailsVM = koinViewModel()
) {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit, block = {
        viewModel.getBreedDetails(breedId)
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
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(color = Color.Cyan)
                        .verticalScroll(scrollState)
                ) {

                    val pagerState = rememberPagerState()

                    HorizontalPager(
                        count = viewModel.imageList.size,
                        state = pagerState,
                        modifier = modifier.weight(1f)
                    ) { imageIndex ->
                        Box {
                            val imagePainter = rememberAsyncImagePainter(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(viewModel.imageList[imageIndex]).crossfade(true)
                                    .size(Size.ORIGINAL).build(),
                                error = painterResource(id = R.drawable.ic_launcher_background),
                            )
                            Image(
                                modifier = Modifier.fillMaxWidth(),
                                painter = imagePainter,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,

                                )
                            if (imagePainter.state is AsyncImagePainter.State.Loading) {
                                CircularProgressIndicator(
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                                    modifier = Modifier
                                        .sizeIn(maxWidth = 56.dp)
                                        .align(Alignment.Center),
                                )
                            }
                        }
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
        BreedDetailsScreen(breedId = "Preview test")
    }
}