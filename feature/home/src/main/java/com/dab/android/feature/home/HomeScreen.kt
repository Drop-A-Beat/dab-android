package com.dab.android.feature.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dab.android.core.designsystem.component.MainTitle
import com.dab.android.core.designsystem.component.StaggeredGrid
import com.dab.android.core.ui.album.AlbumsUiState
import com.dab.android.core.ui.album.albumList
import com.dab.android.core.ui.song.TopSongList

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
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
        topAlbumUiState = topAlbumUiState,
        modifier = modifier
    )

}

@Composable
private fun HomeScreen(
    topAlbumUiState: AlbumsUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        RecentPlayed(topAlbumUiState)
        TopAlbums(topAlbumUiState)
        TopSongs(topAlbumUiState)
    }
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