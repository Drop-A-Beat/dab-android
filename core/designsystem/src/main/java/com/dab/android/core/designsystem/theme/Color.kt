package com.dab.android.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object LightDefaultColorScheme {
    val PrimaryColor = Color(0xFF87C580)
    val SurfaceColor = Color(0xFFFFFFFF)
    val SurfaceVariantColor = Color(0xFFF2F4F6)
    val SubColor = Color(0xFFF2F3F5)
    val SurfaceOppositeColor = Color(0xFF000000)
    val IconColor = Color(0xFFB2B6BF)
    val RedColor = Color(0xFFE16D6D)
    val OrangeColor= Color(0xFFED7739)
}

object DarkDefaultColorScheme {
    val PrimaryColor = Color(0xFF87C580)
    val SurfaceColor = Color(0xFF18171D)
    val SurfaceVariantColor = Color(0xFF101012)
    val SubColor = Color(0xFF2C2C34)
    val SurfaceOppositeColor = Color(0xFFFFFFFF)
    val IconColor = Color(0xFF62626C)
    val RedColor = Color(0xFFE16D6D)
    val OrangeColor= Color(0xFFED7739)
}


@Immutable
data class DabColors(
    val primaryColor: Color,
    val surfaceColor: Color,
    val surfaceVariantColor: Color,
    val surfaceOppositeColor: Color,
    val subColor: Color,
    val iconColor: Color,
    val redColor: Color,
    val orangeColor: Color
)

val LocalDabColors = staticCompositionLocalOf {
    DabColors (
        primaryColor = Color.Blue,
        surfaceColor = Color.White,
        surfaceVariantColor = Color.LightGray,
        subColor = Color.LightGray,
        surfaceOppositeColor = Color.Black,
        iconColor = Color.DarkGray,
        redColor = Color.Red,
        orangeColor = Color.Yellow
    )
}
