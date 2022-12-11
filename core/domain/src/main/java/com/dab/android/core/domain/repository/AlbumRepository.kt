package com.dab.android.core.domain.repository

import com.dab.android.core.model.Album
import com.dab.android.core.model.base.Record

interface AlbumRepository {
    suspend fun getAlbum(): Record<List<Album>>
}