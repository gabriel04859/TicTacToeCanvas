package com.gabsa.canvastictactoe.presentation

import androidx.lifecycle.ViewModel
import com.gabsa.canvastictactoe.domain.model.BoardCellValue
import com.gabsa.canvastictactoe.domain.model.GameStatus
import com.gabsa.canvastictactoe.domain.model.PlayerWinner
import com.gabsa.canvastictactoe.domain.model.UserActions
import com.gabsa.canvastictactoe.domain.model.VictoryType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameStatus())
    val state = _state.asStateFlow()

    var boardITens = mutableMapOf<Int, BoardCellValue>()

    init {
        createBoardItems()
    }

    fun onBoardClicked(action: UserActions) {
        when (action) {
            is UserActions.BoardTapped -> addValueToBoard(action.cellPosition)
            is UserActions.PlayerAgainButtonClicked -> {
                createBoardItems()
                _state.value = GameStatus()
            }
        }
    }

    private fun addValueToBoard(cellPosition: Int) {
        if (boardITens[cellPosition] != BoardCellValue.NONE) {
            return
        }

        val newHintText = if (_state.value.currentTurn == BoardCellValue.CIRCLE) {
            "Player X turn"
        } else {
            "Player O turn"
        }

        val newTurn = if (_state.value.currentTurn == BoardCellValue.CIRCLE) {
            BoardCellValue.CROSS
        } else {
            BoardCellValue.CIRCLE
        }

        boardITens[cellPosition] = _state.value.currentTurn
        if (isDrawGame()) {
            return
        }

        if (checkWinner() != PlayerWinner.NONE) {
            setWinnerInformation()
            return
        }
        _state.value = _state.value.copy(
            hintText = newHintText,
            currentTurn = newTurn
        )
    }

    private fun setWinnerInformation() {
        _state.value = _state.value.copy(
            hintText = "${checkWinner().name} wins",
            hasWinner = true
        )
        countWinnerScore()
    }

    private fun countWinnerScore() {
        return when (checkWinner()) {
            PlayerWinner.CROSS_VICTORY -> {
                _state.value = _state.value.copy(
                    playerCrossCount = _state.value.playerCrossCount + 1
                )
            }

            PlayerWinner.CIRCLE_VICTORY -> {
                _state.value = _state.value.copy(
                    playerCircleCount = _state.value.playerCircleCount + 1
                )
            }

            PlayerWinner.NONE -> Unit
        }
    }

    private fun isDrawGame(): Boolean {
        return if (boardITens.containsValue(BoardCellValue.NONE)) {
            false
        } else {
            _state.value = _state.value.copy(
                hintText = "Draw game",
                drawCount = _state.value.drawCount + 1
            )
            true
        }
    }

    private fun checkWinner(): PlayerWinner {
        val winningCombinations = listOf(
            listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9),
            listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9),
            listOf(1, 5, 9), listOf(3, 5, 7)
        )

        winningCombinations.forEachIndexed { index, combination ->
            val symbols = combination.map { boardITens[it] }
            if (symbols.all { it == BoardCellValue.CIRCLE }) {
                checkVictoryType(index)
                return PlayerWinner.CIRCLE_VICTORY
            } else if (symbols.all { it == BoardCellValue.CROSS }) {
                checkVictoryType(index)
                return PlayerWinner.CROSS_VICTORY
            }

        }

        return PlayerWinner.NONE
    }

    private fun checkVictoryType(index: Int) {
        val currentVictoryType = when (index) {
            0 -> VictoryType.HORIZONTAL1
            1 -> VictoryType.HORIZONTAL2
            2 -> VictoryType.HORIZONTAL3
            3 -> VictoryType.VERTICAL1
            4 -> VictoryType.VERTICAL2
            5 -> VictoryType.VERTICAL3
            6 -> VictoryType.TRANS1
            7 -> VictoryType.TRANS2
            else -> VictoryType.NONE
        }

        _state.value = _state.value.copy(
            victoryType = currentVictoryType
        )
    }

    private fun createBoardItems() {
        for (position in 1..9) {
            boardITens[position] = BoardCellValue.NONE
        }
    }

    fun resetGame() {
        onBoardClicked(
            UserActions.PlayerAgainButtonClicked
        )
    }
}
