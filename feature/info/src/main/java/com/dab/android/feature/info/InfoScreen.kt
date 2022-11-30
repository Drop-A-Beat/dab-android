package com.dab.android.feature.info

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun InfoRoute(
    modifier: Modifier = Modifier
) {
    InfoScreen(
        modifier = modifier
    )
}

@Composable
internal fun InfoScreen(
    modifier: Modifier = Modifier
) {
    Text("info")
}