package com.dab.android.core.domain.interatctor

import com.dab.android.core.domain.BaseUseCase
import com.dab.android.core.domain.repository.AlbumRepository
import com.dab.android.core.model.Album
import com.dab.android.core.model.base.Record
import javax.inject.Inject

class GetTopAlbumUseCase @Inject constructor(private val albumRepository: AlbumRepository) :
    BaseUseCase<Nothing?, Record<List<Album>>>() {

    override suspend fun run(request: Nothing?): Record<List<Album>> {
        return albumRepository.getAlbum()
    }

}