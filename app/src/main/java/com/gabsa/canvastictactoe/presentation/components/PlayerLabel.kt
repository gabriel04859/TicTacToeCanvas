package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.gabsa.canvastictactoe.presentation.theme.LineBoardColor

@Composable
fun PlayerLabel(labelText: String, subLabelText: String, subLabelColor: Color = Color.White) {
    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = labelText, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(text = subLabelText, fontSize = 16.sp, color = subLabelColor)
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerLabelPreview() {
    PlayerLabel(labelText = "Player X", subLabelText = "10")
}