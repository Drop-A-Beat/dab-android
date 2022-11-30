package com.dab.android.core.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class DabTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle
)

val LocalDabTypography = staticCompositionLocalOf {
    DabTypography(
        title1 = TextStyle.Default,
        title2 = TextStyle.Default,
        body1 = TextStyle.Default,
        body2 = TextStyle.Default,
        body3 = TextStyle.Default
    )
}