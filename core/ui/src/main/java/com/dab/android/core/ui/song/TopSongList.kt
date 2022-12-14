package com.dab.android.core.ui.song

import androidx.compose.runtime.Composable
import com.dab.android.core.ui.album.AlbumsUiState

@Composable
fun TopSongList(albumsState: AlbumsUiState) {
    when (albumsState) {
        AlbumsUiState.Loading -> { }
        AlbumsUiState.Error -> { }
        is AlbumsUiState.Success -> {
            albumsState.albums.take(20).forEach { album ->
                TopSongCard(album)
            }
        }
    }
}