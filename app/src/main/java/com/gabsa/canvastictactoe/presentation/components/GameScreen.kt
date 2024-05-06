package com.gabsa.canvastictactoe.presentation.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gabsa.canvastictactoe.R
import com.gabsa.canvastictactoe.domain.model.UserActions
import com.gabsa.canvastictactoe.domain.model.VictoryType
import com.gabsa.canvastictactoe.presentation.GameViewModel
import com.gabsa.canvastictactoe.presentation.theme.BackgroundColor
import com.gabsa.canvastictactoe.presentation.theme.BoardBackground
import com.gabsa.canvastictactoe.presentation.theme.CircleLineColor
import com.gabsa.canvastictactoe.presentation.theme.CrossLineColor

@Composable
fun GameScreen(viewModel: GameViewModel) {
    val state by viewModel.state.collectAsState()

    var currentHeight by remember { mutableStateOf(0f) }
    var currentWidth by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        Text(
            text = stringResource(id = R.string.game_screen_title), fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.White,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            PlayerLabel(
                stringResource(id = R.string.game_screen_player_o),
                "${state.playerCircleCount}",
                CircleLineColor
            )
            PlayerLabel(stringResource(id = R.string.game_screen_player_x), "${state.drawCount}")
            PlayerLabel(
                stringResource(id = R.string.game_screen_player_x),
                "${state.playerCrossCount}",
                CrossLineColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(BoardBackground),
            contentAlignment = Alignment.Center
        ) {
            BoardBase({
                currentHeight = it
            }, {
                currentWidth = it
            })
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)
            ) {
                viewModel.boardITens.forEach { (cellPosition, cellValue) ->
                    item {
                        BoardCell(
                            cellValue = cellValue,
                            isEnable = !state.hasWinner,
                            onCellClicked = {
                                viewModel.onBoardClicked(
                                    UserActions.BoardTapped(
                                        cellPosition
                                    )
                                )
                            }
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    visible = state.hasWinner,
                    enter = fadeIn(tween(2000))
                ) {
                    DrawWinnerLine(victoryType = state.victoryType, currentHeight, currentWidth)
                }
            }
        }
        Text(
            modifier = Modifier.wrapContentSize(),
            text = state.hintText, fontSize = 24.sp, color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            ButtonMain({ viewModel.resetMatch() }, stringResource(id = R.string.game_screen_resent_game_match))

            ButtonMain({ viewModel.resetGame() }, stringResource(id = R.string.game_screen_resent_game_button))

        }
    }
}

@Composable
fun DrawWinnerLine(victoryType: VictoryType, currentHeight: Float, currentWidth: Float) {
    val position = when (victoryType) {
        VictoryType.HORIZONTAL1 -> currentHeight / 6
        VictoryType.HORIZONTAL2 -> currentHeight / 2
        VictoryType.HORIZONTAL3 -> currentHeight * 6 / 7
        VictoryType.VERTICAL1 -> currentWidth / 6
        VictoryType.VERTICAL2 -> currentWidth / 2
        VictoryType.VERTICAL3 -> currentWidth * 6 / 7
        else -> 0f
    }

    when (victoryType) {
        VictoryType.HORIZONTAL1, VictoryType.HORIZONTAL2, VictoryType.HORIZONTAL3 ->
            VerticalWinLine(position)

        VictoryType.VERTICAL1, VictoryType.VERTICAL2, VictoryType.VERTICAL3 ->
            HorizontalWinLine(position)

        VictoryType.TRANS1 -> DiagonallyRightWinLine()
        VictoryType.TRANS2 -> DiagonallyLeftWinLine()

        else -> {}
    }
}

@Composable
@Preview
fun GameScreenPreview() {
    GameScreen(GameViewModel())
}
