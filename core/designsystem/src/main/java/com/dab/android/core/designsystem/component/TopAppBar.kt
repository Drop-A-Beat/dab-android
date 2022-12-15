package com.dab.android.core.designsystem.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

@Composable
fun DabAnimatedToolBar(actionIcon: ImageVector, onActionClick: () -> Unit = {}, scrollState: ScrollState, isInside: Boolean) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .background(if(isInside) Color.Transparent else DabTheme.colors.surfaceColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = "HOME",
            style = DabTheme.typography.headlineSmall.copy(
                color = DabTheme.colors.iconColor,
                fontWeight = FontWeight.Bold
            ),
            color = DabTheme.colors.iconColor,
            modifier = Modifier
                .padding(16.dp)
                .alpha(((scrollState.value + 0.001f) / 200).coerceIn(0f, 1f))
        )
        IconButton(onClick = onActionClick) {
            Icon(
                imageVector = actionIcon,
                contentDescription = " ",
                tint = DabTheme.colors.iconColor
            )
        }
    }
}