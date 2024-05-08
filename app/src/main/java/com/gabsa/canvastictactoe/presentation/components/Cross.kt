package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabsa.canvastictactoe.presentation.theme.CrossLineColor

@Composable
fun Cross() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(20.dp)
    ) {
        drawLine(
            color = CrossLineColor,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )

        drawLine(
            color = CrossLineColor,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = 0f)
        )
    }
}

@Preview
@Composable
fun CrossPreview() {
    Cross()
}


