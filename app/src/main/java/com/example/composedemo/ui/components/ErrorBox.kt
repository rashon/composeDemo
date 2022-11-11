package com.example.composedemo.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorBox(
    message: String, modifier: Modifier = Modifier, onItemClick: () -> Unit = {}
) {
    Card(
        onClick = onItemClick,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_default_triple)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_default_double))
    ) {
        Box {
            Column(
                modifier = modifier
                    .padding(dimensionResource(id = R.dimen.padding_default_triple))
                    .align(Center)
            ) {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding_default)))
                        .align(CenterHorizontally)
                        .sizeIn(maxHeight = dimensionResource(id = R.dimen.error_message_max_size)),
                    painter = painterResource(id = R.drawable.db_error),
                    contentDescription = null,
                )
                Text(modifier = modifier.align(CenterHorizontally), text = message)
            }

        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewErrorBox() {
    ComposeDemoTheme {
        ErrorBox(message = "Some Error")
    }
}