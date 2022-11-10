package com.example.composedemo.ui.fragment.breeddetails

import android.content.res.Configuration
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import androidx.compose.ui.util.lerp
import com.example.composedemo.R
import com.example.composedemo.ui.components.DotsIndicator
import com.example.composedemo.ui.components.ErrorBox
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import org.koin.androidx.compose.koinViewModel
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BreedDetailsScreen(
    modifier: Modifier = Modifier, breedId: String, viewModel: BreedDetailsVM = koinViewModel()
) {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit, block = {
        viewModel.getBreedDetails(breedId)
    })

    Box(modifier = modifier.fillMaxSize()) {
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
                        .verticalScroll(scrollState)
                ) {

                    val pagerState = rememberPagerState()
                    var pageSize by remember { mutableStateOf(IntSize.Zero) }
                    val lastIndex by remember(pagerState.currentPage) {
                        derivedStateOf { pagerState.currentPage == viewModel.imageList.size - 1 }
                    }

                    Box {
                        HorizontalPager(
                            count = viewModel.imageList.size,
                            state = pagerState,
                            modifier = modifier.align(Alignment.TopCenter)
                        ) { imageIndex ->
                            Box(
                                modifier = modifier
                                    .sizeIn(
                                        minHeight = 2400.dp, maxHeight = 240.dp
                                    )
                                    .graphicsLayer {
                                        // Calculate the absolute offset for the current page from the
                                        // scroll position. We use the absolute value which allows us to mirror
                                        // any effects for both directions
                                        val pageOffset =
                                            calculateCurrentOffsetForPage(imageIndex).absoluteValue

                                        // We animate the scaleX + scaleY, between 85% and 100%
                                        lerp(
                                            start = 0.55f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        ).also { scale ->
                                            scaleX = scale
                                            scaleY = scale
                                        }

                                        // We animate the alpha, between 50% and 100%
                                        alpha = lerp(
                                            start = 0.5f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        )
                                    }
                                    .onSizeChanged { pageSize = it }
                            ) {
                                val imagePainter = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(viewModel.imageList[imageIndex]).crossfade(true)
                                        .build()
                                )
                                Image(
                                    modifier = Modifier.fillMaxWidth(),
                                    painter = imagePainter,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )

                                Spacer(modifier = Modifier.padding(4.dp))

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

                        DotsIndicator(
                            modifier = modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 32.dp),
                            totalDots = viewModel.imageList.size,
                            selectedIndex = pagerState.currentPage,
                            selectedColor = MaterialTheme.colorScheme.onPrimary,
                            unSelectedColor = MaterialTheme.colorScheme.primary
                        )

                        LaunchedEffect(pagerState.currentPage) {
                            while (true) {
                                yield()
                                delay(6000)
//                            // increasing the position and check the limit
//                            var newPosition = pagerState.currentPage + 1
//                            if (newPosition > viewModel.imageList.lastIndex) newPosition = 0
//                            // scrolling to the new position.
//                            pagerState.animateScrollToPage(newPosition)
                                pagerState.animateScrollBy(
                                    value = if (lastIndex) -(pageSize.width.toFloat() * viewModel.imageList.size) else pageSize.width.toFloat(),
                                    animationSpec = tween(if (lastIndex) 2000 else 1400)
                                )
                            }
                        }

                    }

                    Text(
                        text = breedId.uppercase(),
                        modifier = modifier
                            .padding(8.dp)
                            .align(CenterHorizontally),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = stringResource(id = R.string.bla_bla_text),
                        modifier = modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
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