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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorBox(
    message: String, modifier: Modifier = Modifier, onItemClick: () -> Unit = {}
) {
    Card(
        onClick = onItemClick, modifier = Modifier.padding(24.dp), shape = RoundedCornerShape(16.dp)
    ) {
        Box {
            Column(
                modifier = modifier
                    .padding(24.dp)
                    .align(Center)
            ) {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .align(CenterHorizontally)
                        .sizeIn(maxHeight = 120.dp),
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