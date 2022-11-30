package com.dab.android.core.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val BottomSheetShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)

@Immutable
data class DabShapes(
    val bottomSheetShape: Shape,
    val smallRoundCornerShape: Shape,
    val mediumRoundCornerShape: Shape,
    val largeRoundCornerShape: Shape,
    val circleRoundCornerShape: Shape
)

val LocalDabShapes = staticCompositionLocalOf {
    DabShapes(
        bottomSheetShape = RoundedCornerShape(ZeroCornerSize),
        smallRoundCornerShape = RoundedCornerShape(ZeroCornerSize),
        mediumRoundCornerShape = RoundedCornerShape(ZeroCornerSize),
        largeRoundCornerShape = RoundedCornerShape(ZeroCornerSize),
        circleRoundCornerShape = RoundedCornerShape(ZeroCornerSize)
    )
}