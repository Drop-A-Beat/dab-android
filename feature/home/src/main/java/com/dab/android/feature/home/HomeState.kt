package com.dab.android.feature.home

import com.dab.android.core.model.base.ErrorRecord
import com.dab.android.core.ui.album.AlbumsUiState

data class HomeState (
    val topAlbumState : AlbumsUiState = AlbumsUiState.Loading,
    val error: ErrorRecord? = null
)