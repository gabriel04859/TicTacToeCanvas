package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gabsa.canvastictactoe.presentation.theme.CircleLineColor
import com.gabsa.canvastictactoe.presentation.theme.CrossLineColor

@Composable
fun PlayerWinnerLabel(text: String) {
    val color = when (text) {
        "Player X wins" -> CrossLineColor
        "Player O wins" -> CircleLineColor
        else -> Color.White
    }

    Text(
        modifier = Modifier.wrapContentSize(),
        text = text,
        fontSize = 24.sp,
        color = color,
        fontWeight = FontWeight.Bold
    )
}