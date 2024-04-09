package com.gabsa.canvastictactoe.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabsa.canvastictactoe.ui.theme.WinLineColor

@Composable
fun VerticalWinLine(heightPosition: Float) {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
    ) {
        drawLine(
            color = WinLineColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = heightPosition),
            end = Offset(x = size.height, y = heightPosition)
        )
    }
}

@Composable
fun HorizontalWinLine(widthPosition: Float) {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
    ) {
        drawLine(
            color = WinLineColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = widthPosition, y = 0f),
            end = Offset(x = widthPosition, y = size.width)
        )
    }
}

@Composable
fun TransWinLine(startPosition: Float, endPosition: Float) {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
    ) {
        drawLine(
            color = WinLineColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = startPosition, y = startPosition),
            end = Offset(x = endPosition, y = endPosition)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VerticalWinLinePreview() {
    TransWinLine(300f, 0f)
}