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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.composedemo.R
import com.example.composedemo.data.model.BreedModel
import com.example.composedemo.ui.theme.ComposeDemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BreedsListItem(
    item: BreedModel, modifier: Modifier = Modifier, onItemClick: () -> Unit = {}
) {
    Card(
        onClick = onItemClick, modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            val imagePainter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current).data(item.imageUrls?.first())
                    .crossfade(true).size(Size.ORIGINAL).build(),
                error = painterResource(id = R.drawable.ic_launcher_background),
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                painter = imagePainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )
            if (imagePainter.state is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .sizeIn(maxWidth = 56.dp)
                        .align(Alignment.Center),
                )
            }
//            Column(
//                modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)) {
            TextWithShadow(
                text = item.name,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.surface,
                shadowColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .align(BottomCenter)
                    .background(MaterialTheme.colorScheme.background.copy(alpha = 0.4f))
                    .fillMaxWidth()
                    .padding(8.dp)
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