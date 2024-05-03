package com.gabsa.canvastictactoe.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gabsa.canvastictactoe.presentation.components.GameScreen
import com.gabsa.canvastictactoe.presentation.theme.CanvasTicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTicTacToeTheme {
                val viewModel = GameViewModel()
                GameScreen(viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CanvasTicTacToeTheme {

    }
}