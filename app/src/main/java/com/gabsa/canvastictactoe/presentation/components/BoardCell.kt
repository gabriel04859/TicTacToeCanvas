package com.gabsa.canvastictactoe.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gabsa.canvastictactoe.domain.model.BoardCellValue

@Composable
fun BoardCell(
    cellValue: BoardCellValue,
    onCellClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = onCellClicked
            )
    ) {
        when (cellValue) {
            BoardCellValue.CIRCLE -> Circle()
            BoardCellValue.CROSS -> Cross()
            else -> {
                Unit
            }
        }
    }
}