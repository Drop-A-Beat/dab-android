package com.dab.android.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.dab.android.app.navigation.TopLevelDestination
import com.dab.android.app.navigation.TopLevelDestination.DAB_HOME
import com.dab.android.app.navigation.TopLevelDestination.DAB_INFO
import com.dab.android.app.navigation.TopLevelDestination.DAB_PLAY_LIST
import com.dab.android.app.navigation.TopLevelDestination.DAB_SEARCH
import com.dab.android.core.data.util.NetworkMonitor
import com.dab.android.feature.home.navigation.homeRoute
import com.dab.android.feature.home.navigation.navigateToHome
import com.dab.android.feature.info.navigation.infoRoute
import com.dab.android.feature.info.navigation.navigateToInfo
import com.dab.android.feature.playlist.navigation.navigateToPlayList
import com.dab.android.feature.playlist.navigation.playListRoute
import com.dab.android.feature.search.navigation.navigateToSearch
import com.dab.android.feature.search.navigation.searchRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberDabAppState(
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): DabAppState {
    return remember(navController, coroutineScope, networkMonitor) {
        DabAppState(navController, coroutineScope, networkMonitor)
    }
}

@Stable
class DabAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> DAB_HOME
            playListRoute -> DAB_PLAY_LIST
            searchRoute -> DAB_SEARCH
            infoRoute -> DAB_INFO
            else -> null
        }

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun onBackClick() {
        navController.navigateUp()
    }

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                DAB_HOME -> navController.navigateToHome(topLevelNavOptions)
                DAB_PLAY_LIST -> navController.navigateToPlayList(topLevelNavOptions)
                DAB_SEARCH -> navController.navigateToSearch(topLevelNavOptions)
                DAB_INFO -> navController.navigateToInfo(topLevelNavOptions)
            }
        }
    }
}
