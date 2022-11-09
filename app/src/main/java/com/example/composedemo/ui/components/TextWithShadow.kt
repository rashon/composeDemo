package com.example.composedemo.ui.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TextWithShadow(
    text: String, modifier: Modifier, textAlign: TextAlign, color: Color, shadowColor: Color
) {
    Text(
        text = text,
        color = color,
        textAlign = textAlign,
        modifier = modifier
            .offset(x = 1.dp, y = 2.dp)
            .alpha(0.3f)
    )
    Text(
        text = text,
        textAlign = textAlign,
        color = shadowColor,
        modifier = modifier
    )
}