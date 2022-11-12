package com.example.composedemo.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.composedemo.R
import com.example.composedemo.domain.model.BreedModel
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BreedsListItem(
    item: BreedModel, modifier: Modifier = Modifier, onItemClick: () -> Unit = {}
) {
    Card(
        onClick = onItemClick,
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_default)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_default_double))
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.lazy_grid_item_height))
        ) {
            val imagePainter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current).data(item.imageUrls?.first())
                    .crossfade(true).size(Size.ORIGINAL).build()
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding_default))),
                painter = imagePainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            if (imagePainter.state is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                    modifier = Modifier
                        .sizeIn(maxWidth = dimensionResource(id = R.dimen.progress_bar_size))
                        .align(Alignment.Center),
                )
            }

            TextWithShadow(
                text = item.name.uppercase(),
                textAlign = TextAlign.Center,
                textColor = White,
                style = MaterialTheme.typography.labelLarge.copy(lineHeight = 16.sp),
                modifier = Modifier
                    .align(BottomCenter)
                    .background(Color.Black.copy(alpha = 0.15f))
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_default))
            )
        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBreedsListItem() {
    ComposeDemoTheme {
        BreedsListItem(BreedModel("Preview Test"))
    }
}