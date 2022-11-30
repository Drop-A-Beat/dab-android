package com.dab.android.feature.playlist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PlayListRoute(
    modifier: Modifier = Modifier
) {
    PlayListScreen(
        modifier = modifier
    )
}

@Composable
internal fun PlayListScreen(
    modifier: Modifier = Modifier
) {
    Text("play list")
}