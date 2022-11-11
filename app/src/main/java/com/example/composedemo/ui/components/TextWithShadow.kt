package com.example.composedemo.ui.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.composedemo.R

@Composable
fun TextWithShadow(
    text: String,
    modifier: Modifier,
    textAlign: TextAlign,
    color: Color,
    shadowColor: Color,
    style: TextStyle
) {
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
        color = color,
        style = style,
        modifier = modifier
    )
}