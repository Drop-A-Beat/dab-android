package com.dab.android.app.ui

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.dab.android.app.R
import com.dab.android.app.navigation.DabNavHost
import com.dab.android.app.navigation.TopLevelDestination
import com.dab.android.core.data.util.NetworkMonitor
import com.dab.android.core.designsystem.component.DabNavigationBar
import com.dab.android.core.designsystem.component.DabNavigationBarItem
import com.dab.android.core.designsystem.component.DabSurface
import com.dab.android.core.designsystem.component.DabTopAppBar
import com.dab.android.core.designsystem.icon.DabIcons
import com.dab.android.core.designsystem.icon.Icon

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalLifecycleComposeApi::class
)
@Composable
fun DabApp(
    networkMonitor: NetworkMonitor,
    appState: DabAppState = rememberDabAppState(
       networkMonitor = networkMonitor
    )
) {
    val surface: @Composable (@Composable () -> Unit) -> Unit = {
        content -> DabSurface(content = content)
    }

    surface {
        val snackbarHostState = remember { SnackbarHostState() }

        Scaffold(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                val destination = appState.currentTopLevelDestination
                if (destination != null && destination != TopLevelDestination.DAB_HOME) {
                    DabTopAppBar(
                        modifier = Modifier.zIndex(-1F),
                        title = destination.iconTextId,
                        actionIcon = DabIcons.Settings,
                        actionIconContentDescription = "",
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = Color.Transparent
                        ),
                        onActionClick = {  }
                    )
                }
            },
            bottomBar = {
                DabBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }
        ) { padding ->
            val isOffline by appState.isOffline.collectAsStateWithLifecycle()

            val notConnected = stringResource(R.string.not_connected)
            LaunchedEffect(isOffline) {
                if (isOffline) snackbarHostState.showSnackbar(
                    message = notConnected,
                    duration = SnackbarDuration.Indefinite
                )
            }

            DabNavHost(
                navController = appState.navController,
                onBackClick = appState::onBackClick,
                modifier = Modifier
                    .padding(padding)
                    .consumedWindowInsets(padding)
            )
        }

    }
}


@Composable
private fun DabBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    DabNavigationBar {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            DabNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    when (val icon = destination.icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )
                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )
                    }
                },
                label = { Text(destination.iconTextId) }
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name.substring(4), true) ?: false
    } ?: false