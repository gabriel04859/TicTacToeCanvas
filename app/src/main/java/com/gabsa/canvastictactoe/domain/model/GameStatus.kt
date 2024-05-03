package com.gabsa.canvastictactoe.domain.model

data class GameStatus(
    val playerCircleCount: Int = 0,
    val playerCrossCount: Int = 0,
    val drawCount: Int = 0,
    val hintText: String = "Player X turn",
    val currentTurn: BoardCellValue = BoardCellValue.CROSS,
    val victoryType: VictoryType = VictoryType.NONE
)

enum class BoardCellValue {
    CIRCLE,
    CROSS,
    NONE
}

enum class VictoryType {
    CROSS_VICTORY,
    CIRCLE_VICTORY,
    NONE
}
