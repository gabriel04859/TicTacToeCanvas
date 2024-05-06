package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.gabsa.canvastictactoe.presentation.theme.LineBoardColor

@Composable
fun BoardBase(currentHeight: (Float) -> Unit, currentWidth: (Float) -> Unit) {
    val modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .onGloballyPositioned { coordinates ->
            currentHeight(coordinates.size.height.toFloat())
            currentWidth(coordinates.size.width.toFloat())
        }

    Canvas(
        modifier = modifier
    ) {
        drawLine(
            color = LineBoardColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 1 / 3, y = 0f),
            end = Offset(x = size.width * 1 / 3, y = size.height)
        )

        drawLine(
            color = LineBoardColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 2 / 3, y = 0f),
            end = Offset(x = size.width * 2 / 3, y = size.height)
        )

        drawLine(
            color = LineBoardColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 1 / 3),
            end = Offset(x = size.width, y = size.height * 1 / 3)
        )

        drawLine(
            color = LineBoardColor,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 2 / 3),
            end = Offset(x = size.width, y = size.height * 2 / 3)
        )
    }
}
