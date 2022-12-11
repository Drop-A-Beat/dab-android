package com.dab.android.core.data.datasource

import com.dab.android.core.data.model.response.AlbumListResponse

interface DabDataSource {
    suspend fun getTopAlbum(): Result<AlbumListResponse>
}