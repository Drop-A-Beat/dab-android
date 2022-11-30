package com.dab.android.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dab.android.core.designsystem.theme.DabTheme

@Composable
fun DabSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val color = DabTheme.colors.surfaceColor
    val tonalElevation = 0.dp
    Surface(
        color = color,
        tonalElevation = tonalElevation,
        modifier = modifier.fillMaxSize(),
    ) {
        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
            content()
        }
    }
}