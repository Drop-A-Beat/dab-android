package com.dab.android.core.ui.album

import androidx.compose.foundation.lazy.LazyListScope
import com.dab.android.core.model.Album

fun LazyListScope.albumList(
    albumsState: AlbumsUiState
) {
    when (albumsState) {
        AlbumsUiState.Loading -> { }
        AlbumsUiState.Error -> { }
        is AlbumsUiState.Success -> {
            items(albumsState.albums.size) { index ->
                AlbumCard(
                    album = albumsState.albums[index]
                )
            }
        }
    }
}

sealed interface AlbumsUiState {
    object Loading : AlbumsUiState
    object Error : AlbumsUiState
    data class Success(
        val albums: List<Album>
    ) : AlbumsUiState
}