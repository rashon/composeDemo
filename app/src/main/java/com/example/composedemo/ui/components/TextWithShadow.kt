package com.example.composedemo.ui.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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
            .offset(x = 1.dp, y = 1.dp)
            .alpha(0.5f)
            .blur(2.dp)
    )
    Text(
        text = text,
        textAlign = textAlign,
        color = color,
        style = style,
        modifier = modifier
    )
}