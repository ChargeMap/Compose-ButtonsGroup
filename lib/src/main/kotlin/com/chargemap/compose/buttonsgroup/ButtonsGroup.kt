package com.chargemap.compose.buttonsgroup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

class StateColors(
    val active: Color,
    val inActive: Color,
)

@Composable
fun ButtonsGroup(
    modifier: Modifier = Modifier,
    value: Int,
    size: Int = 1,
    onValueChange: (Int) -> Unit,
    strokeWidth: Dp = 1.dp,
    strokeColors: StateColors = StateColors(MaterialTheme.colors.primary, Color.DarkGray.copy(alpha = 0.75f)),
    backgroundColors: StateColors = StateColors(MaterialTheme.colors.surface, MaterialTheme.colors.surface),
    cornerRadius: Dp? = null,
    content: @Composable (Int) -> Unit = {},
) {
    val radius = cornerRadius ?: 8.dp

    Row(
        modifier = modifier
    ) {
        repeat((0 until size).count()) { index ->
            OutlinedButton(
                modifier = Modifier
                    .weight(1f)
                    .offset(
                        when (index) {
                            0 -> 0.dp
                            else -> -(strokeWidth.value * (index)).dp
                        }, 0.dp
                    )
                    .zIndex(
                        when (value) {
                            index -> 1f
                            else -> 0f
                        }
                    ),
                onClick = { onValueChange(index) },
                shape = when (index) {
                    // left outer button
                    0 -> RoundedCornerShape(topStart = radius, topEnd = 0.dp, bottomStart = radius, bottomEnd = 0.dp)
                    // right outer button
                    size - 1 -> RoundedCornerShape(topStart = 0.dp, topEnd = radius, bottomStart = 0.dp, bottomEnd = radius)
                    // middle button
                    else -> RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
                },
                border = BorderStroke(
                    strokeWidth,
                    when (value) {
                        index -> strokeColors.active
                        else -> strokeColors.inActive
                    }
                ),
                colors = if (value == index) {
                    // selected colors
                    ButtonDefaults.outlinedButtonColors(backgroundColor = backgroundColors.active, contentColor = strokeColors.active)
                } else {
                    // not selected colors
                    ButtonDefaults.outlinedButtonColors(backgroundColor = backgroundColors.inActive, contentColor = strokeColors.inActive)
                },
                content = {
                    content(index)
                }
            )
        }
    }
}