package com.dab.android.feature.home

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.dab.android.core.designsystem.component.DabAnimatedToolBar
import com.dab.android.core.designsystem.component.MainTitle
import com.dab.android.core.designsystem.component.StaggeredGrid
import com.dab.android.core.designsystem.icon.DabIcons
import com.dab.android.core.designsystem.theme.DabTheme
import com.dab.android.core.ui.R
import com.dab.android.core.ui.album.AlbumsUiState
import com.dab.android.core.ui.album.albumList
import com.dab.android.core.ui.song.TopSongList
import com.dab.android.feature.home.util.isInside
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    val state: HomeState by viewModel.uiState.collectAsStateWithLifecycle()
    val topAlbumUiState = state.topAlbumState

    LaunchedEffect(viewModel.uiSideEffect) {
        viewModel.uiSideEffect.collect { sideEffect ->
            when (sideEffect) {
                is HomeSideEffect.GetTopAlbum -> viewModel.setTopAlbum(sideEffect.albumsUiState)
            }
        }
    }

    HomeScreen(
        systemUiController = systemUiController,
        topAlbumUiState = topAlbumUiState,
        modifier = modifier
    )

}

@Composable
private fun HomeScreen(
    systemUiController: SystemUiController,
    topAlbumUiState: AlbumsUiState,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    systemUiController.setStatusBarColor(if(scrollState.isInside()) Color.Transparent else DabTheme.colors.surfaceColor)
    Box{
        val dynamicValue = 344.dp - Dp(scrollState.value / 2f)
        val animateImageSize = animateDpAsState(dynamicValue).value
        if(scrollState.isInside()) {
            AsyncImage(
                modifier = Modifier
                    .height(animateImageSize),
                placeholder = painterResource(id = R.drawable.ic_playlist),
                contentScale = ContentScale.Crop,
                model = "https://charts-static.billboard.com/img/2022/07/steve-lacy-d2o-badhabit-l6b-344x344.jpg",
                contentDescription = null
            )
        }

    }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(scrollState)
    ) {
        Spacer( modifier = Modifier.height(200.dp) )
        RecentPlayed(topAlbumUiState)
        TopAlbums(topAlbumUiState)
        TopSongs(topAlbumUiState)
    }

    DabAnimatedToolBar(
        actionIcon = DabIcons.Settings,
        onActionClick = {  },
        scrollState = scrollState,
        isInside = scrollState.isInside()
    )


}
@Composable
private fun RecentPlayed(topAlbumUiState: AlbumsUiState) {
    MainTitle("Recently Played", modifier = Modifier.padding(top = 0.dp))
    LazyRow {
        albumList(topAlbumUiState)
    }
}
@Composable
private fun TopAlbums(topAlbumUiState: AlbumsUiState) {
    MainTitle("Charts: Top 50")
    LazyRow {
        albumList(topAlbumUiState)
    }
}

@Composable
private fun TopSongs(topAlbumUiState: AlbumsUiState) {
    MainTitle("Charts: Hot Tracks")
    StaggeredGrid(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {
        TopSongList(topAlbumUiState)
    }
}