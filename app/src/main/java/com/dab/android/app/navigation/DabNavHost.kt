package com.dab.android.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dab.android.feature.home.navigation.homeRoute
import com.dab.android.feature.home.navigation.homeScreen
import com.dab.android.feature.info.navigation.infoScreen
import com.dab.android.feature.playlist.navigation.playListScreen
import com.dab.android.feature.search.navigation.searchScreen

@Composable
fun DabNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = homeRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        playListScreen()
        searchScreen()
        infoScreen()
    }
}