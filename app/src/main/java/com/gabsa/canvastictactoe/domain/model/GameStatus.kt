package com.gabsa.canvastictactoe.domain.model

data class GameStatus(
    val playerCircleCount: Int = 0,
    val playerCrossCount: Int = 0,
    val drawCount: Int = 0,
    val hintText: String = "Player X turn",
    val currentTurn: BoardCellValue = BoardCellValue.CROSS,
    val playerWinner: PlayerWinner = PlayerWinner.NONE,
    val victoryType: VictoryType = VictoryType.NONE,
    val hasWinner: Boolean = false
)

enum class BoardCellValue {
    CIRCLE,
    CROSS,
    NONE
}

enum class VictoryType {
    HORIZONTAL1,
    HORIZONTAL2,
    HORIZONTAL3,
    VERTICAL1,
    VERTICAL2,
    VERTICAL3,
    TRANS1,
    TRANS2,
    NONE
}

enum class PlayerWinner {
    CROSS_VICTORY,
    CIRCLE_VICTORY,
    NONE
}