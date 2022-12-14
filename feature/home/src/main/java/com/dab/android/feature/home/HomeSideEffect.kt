package com.dab.android.feature.home

import com.dab.android.core.ui.album.AlbumsUiState

sealed class HomeSideEffect {
    class GetTopAlbum(val albumsUiState: AlbumsUiState) : HomeSideEffect()
}