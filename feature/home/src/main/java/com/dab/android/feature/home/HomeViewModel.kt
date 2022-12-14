package com.dab.android.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dab.android.core.common.viewmodel.BaseViewModel
import com.dab.android.core.domain.interatctor.GetTopAlbumUseCase
import com.dab.android.core.model.Album
import com.dab.android.core.ui.album.AlbumsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopAlbumUseCase: GetTopAlbumUseCase
): BaseViewModel<HomeState, HomeSideEffect>(HomeState()) {
    init {
        getTopAlbum()
    }
    private fun getTopAlbum() = intent {
        getTopAlbumUseCase.invoke()
            .map {
                if(it.data == null) throw Exception()
                it.data as List<Album>
            }
            .map<List<Album>, AlbumsUiState>(AlbumsUiState::Success)
            .onStart { AlbumsUiState.Loading }
            .catch { AlbumsUiState.Error }
            .collect { postSideEffect(HomeSideEffect.GetTopAlbum(albumsUiState = it)) }
    }
    fun setTopAlbum(albumsUiState: AlbumsUiState) = intent {
        reduce { state.copy(topAlbumState = albumsUiState) }
    }

}