package com.dab.android.feature.info.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.dab.android.feature.info.InfoRoute

const val infoRoute = "info_route"

fun NavController.navigateToInfo(navOptions: NavOptions? = null) {
    this.navigate(infoRoute, navOptions)
}

fun NavGraphBuilder.infoScreen() {
    composable(route = infoRoute) {
        InfoRoute()
    }
}