package com.dab.android.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dab.android.core.common.result.Result
import com.dab.android.core.common.result.asResult
import com.dab.android.core.domain.interatctor.GetTopAlbumUseCase
import com.dab.android.core.ui.album.AlbumsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopAlbumUseCase: GetTopAlbumUseCase
): ViewModel() {

    init {

    }

    val topAlbumUiState: StateFlow<AlbumsUiState> = topAlbumUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AlbumsUiState.Loading
        )

    private fun topAlbumUiState(): Flow<AlbumsUiState> {
        return getTopAlbumUseCase.invoke().asResult().map {
            when(it){
                is Result.Success -> {
                    it.result.data?.let { albums ->
                        AlbumsUiState.Success(albums)
                    }?:run{ AlbumsUiState.Error }
                }
                is Result.Loading -> AlbumsUiState.Loading
                is Result.Error -> AlbumsUiState.Error
            }
        }
    }




}