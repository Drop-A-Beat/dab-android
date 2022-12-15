package com.dab.android.core.designsystem.component

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import com.dab.android.core.designsystem.theme.DabTheme

@Composable
fun DabBottomDivider() {
    Divider(
        color = DabTheme.colors.iconColor.copy(alpha = 0.1f)
    )
}