package com.dab.android.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.dp


@Composable
fun DabTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val localDabColors = if(darkTheme) DarkTheme else LightTheme

    val localDabShapes = DabShapes(
        bottomSheetShape = BottomSheetShape,
        smallRoundCornerShape = RoundedCornerShape(6.dp),
        mediumRoundCornerShape = RoundedCornerShape(8.dp),
        largeRoundCornerShape = RoundedCornerShape(10.dp),
        circleRoundCornerShape = RoundedCornerShape(20.dp)
    )

    val localDabTypography = DabTypography

    CompositionLocalProvider(
        LocalDabColors provides localDabColors,
        LocalDabShapes provides localDabShapes,
        LocalDabTypography provides localDabTypography
    ) {
        MaterialTheme(content = content)
    }
}

private val LightTheme = DabColors(
    primaryColor = LightDefaultColorScheme.PrimaryColor,
    surfaceColor = LightDefaultColorScheme.SurfaceColor,
    surfaceVariantColor = LightDefaultColorScheme.SurfaceVariantColor,
    subColor = LightDefaultColorScheme.SubColor,
    surfaceOppositeColor = LightDefaultColorScheme.SurfaceOppositeColor,
    iconColor = LightDefaultColorScheme.IconColor,
    redColor = LightDefaultColorScheme.RedColor,
    orangeColor = LightDefaultColorScheme.OrangeColor
)

private val DarkTheme = DabColors(
    primaryColor = DarkDefaultColorScheme.PrimaryColor,
    surfaceColor = DarkDefaultColorScheme.SurfaceColor,
    surfaceVariantColor = DarkDefaultColorScheme.SurfaceVariantColor,
    subColor = DarkDefaultColorScheme.SubColor,
    surfaceOppositeColor = DarkDefaultColorScheme.SurfaceOppositeColor,
    iconColor = DarkDefaultColorScheme.IconColor,
    redColor = DarkDefaultColorScheme.RedColor,
    orangeColor = DarkDefaultColorScheme.OrangeColor
)

object DabTheme {
    val colors: DabColors
        @Composable
        @ReadOnlyComposable
        @NonRestartableComposable
        get() = LocalDabColors.current

    val shapes: DabShapes
        @Composable
        @ReadOnlyComposable
        @NonRestartableComposable
        get() = LocalDabShapes.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        @NonRestartableComposable
        get() = LocalDabTypography.current
}