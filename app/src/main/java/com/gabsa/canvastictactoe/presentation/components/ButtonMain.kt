package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonMain(action: () -> Unit, text: String) {

    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF606060)
    )

    Button(
        onClick = {
            action.invoke()
        },
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp),
        colors = mainButtonColor,
        elevation = ButtonDefaults.buttonElevation(5.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun OutlineButtonMain(action: () -> Unit, text: String) {

    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF606060)
    )

    OutlinedButton(
        onClick = {
            action.invoke()
        },
        shape = ButtonDefaults.elevatedShape,
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp),
        elevation = ButtonDefaults.buttonElevation(5.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}