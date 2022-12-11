package com.dab.android.core.ui.song

import androidx.compose.runtime.Composable
import com.dab.android.core.ui.album.AlbumsUiState

@Composable
fun TopSongList(albumsState: AlbumsUiState) {
    when (albumsState) {
        AlbumsUiState.Loading -> Unit
        AlbumsUiState.Error -> Unit
        is AlbumsUiState.Success -> {
            albumsState.albums.forEach { album ->
                TopSongCard(album)
            }
        }
    }
}