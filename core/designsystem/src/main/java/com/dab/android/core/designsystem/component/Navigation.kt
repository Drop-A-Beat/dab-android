package com.dab.android.core.designsystem.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dab.android.core.designsystem.theme.DabTheme

@Composable
fun DabNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        contentColor = DabTheme.colors.surfaceVariantColor,
        tonalElevation = 0.dp,
        content = content
    )
}

@Composable
fun RowScope.DabNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon =  icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = DabTheme.colors.primaryColor,
            unselectedIconColor = DabTheme.colors.surfaceOppositeColor,
            selectedTextColor = DabTheme.colors.primaryColor,
            unselectedTextColor = DabTheme.colors.surfaceOppositeColor,
            indicatorColor = Color.Transparent
        )
    )
}