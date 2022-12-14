package com.dab.android.core.designsystem.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.dab.android.core.designsystem.theme.DabTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DabTopAppBar(
    title: String,
    actionIcon: ImageVector,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onActionClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(
            text = title,
            style = DabTheme.typography.headlineSmall.copy(
                color = DabTheme.colors.iconColor,
                fontWeight = FontWeight.Bold
            )
        ) },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = DabTheme.colors.iconColor
                )
            }
        },
        colors = colors,
        modifier = modifier,
    )
}