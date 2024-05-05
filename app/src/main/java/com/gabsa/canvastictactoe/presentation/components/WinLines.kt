package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabsa.canvastictactoe.presentation.theme.WinLineColor

@Composable
fun VerticalWinLine(heightPosition: Float) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        drawLine(
            color = WinLineColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f, y = heightPosition),
                end = Offset(x = size.height, y = heightPosition)
            )
    }
}


@Composable
fun HorizontalWinLine(widthPosition: Float,  modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
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
fun DiagonallyRightWinLine() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            color = WinLineColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0.dp.toPx(), y = 0f),
            end = Offset(x = canvasWidth, y = canvasHeight)
        )
    }
}

@Composable
fun DiagonallyLeftWinLine(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            color = WinLineColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0.dp.toPx(), y = canvasHeight)
        )
    }
}

@Preview()
@Composable
fun VerticalWinLinePreview() {
    DiagonallyLeftWinLine()
}