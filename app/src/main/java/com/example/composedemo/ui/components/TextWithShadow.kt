package com.example.composedemo.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.R
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.theme.White

@Composable
fun TextWithShadow(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    shadowColor: Color = MaterialTheme.colorScheme.primary,
    style: TextStyle = MaterialTheme.typography.bodySmall
) {
    //Text shadow
    Text(
        text = text,
        color = shadowColor,
        textAlign = textAlign,
        style = style,
        modifier = modifier
            .offset(
                x = dimensionResource(id = R.dimen.text_shadow_offset),
                y = dimensionResource(id = R.dimen.text_shadow_offset)
            )
            .alpha(0.5f)
            .blur(dimensionResource(id = R.dimen.text_shadow_blur))
    )
    Text(
        text = text,
        textAlign = textAlign,
        color = textColor,
        style = style,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTextShadow() {
    ComposeDemoTheme {
        TextWithShadow(text = "Test", textColor = White)
    }
}