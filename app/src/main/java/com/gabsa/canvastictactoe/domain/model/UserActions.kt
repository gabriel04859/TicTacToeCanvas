package com.gabsa.canvastictactoe.domain.model

sealed class UserActions {
    object PlayerAgainButtonClicked : UserActions()
    data class BoardTapped(val cellPosition: Int) : UserActions()

    object ResetMatchButtonClicked : UserActions()
}
