package com.dab.android.feature.playlist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.dab.android.feature.playlist.PlayListRoute

const val playListRoute = "play_list_route"

fun NavController.navigateToPlayList(navOptions: NavOptions? = null) {
    this.navigate(playListRoute, navOptions)
}

fun NavGraphBuilder.playListScreen() {
    composable(route = playListRoute) {
        PlayListRoute()
    }
}