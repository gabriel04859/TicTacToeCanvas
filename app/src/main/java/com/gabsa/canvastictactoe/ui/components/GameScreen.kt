package com.gabsa.canvastictactoe.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gabsa.canvastictactoe.ui.theme.Pink80
import com.gabsa.canvastictactoe.ui.theme.PurpleGrey40

@Composable
fun GameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleGrey40)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Player '0' : 0", fontSize = 16.sp)
            Text(text = "Draw: 0", fontSize = 16.sp)
            Text(text = "Player 'x' : 0", fontSize = 16.sp)
        }
        Text(
            text = "Tic tac toe", fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(Pink80),
            contentAlignment = Alignment.Center
        ) {
            BoardBase()
        }
        Text(
            modifier = Modifier.wrapContentSize(),
            text = "Player '0' turn", fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Button(onClick = { /*TODO*/ },
            modifier = Modifier.wrapContentSize(),
            elevation = ButtonDefaults.buttonElevation(5.dp)) {
            Text(text = "Reset game")
        }
    }
}

@Composable
@Preview
fun GameScreenPreview() {
    GameScreen()
}
