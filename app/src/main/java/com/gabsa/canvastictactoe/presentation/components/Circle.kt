package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabsa.canvastictactoe.presentation.theme.CircleLineColor

@Composable
fun Circle() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(20.dp)
    ) {
        drawCircle(
            color = CircleLineColor,
            style = Stroke(20f)
        )
    }
}

@Preview
@Composable
fun CirclePreview() {
    Circle()
}