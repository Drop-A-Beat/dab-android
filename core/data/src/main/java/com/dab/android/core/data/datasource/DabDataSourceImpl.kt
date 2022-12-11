package com.dab.android.core.data.datasource

import com.dab.android.core.data.model.response.AlbumListResponse
import com.dab.android.core.data.service.DabService
import javax.inject.Inject

class DabDataSourceImpl @Inject constructor(
    private val dabService: DabService
): DabDataSource {
    override suspend fun getTopAlbum(): Result<AlbumListResponse> =
       runCatching {
            dabService.getTopAlbum()
        }.onSuccess {
            Result.success(it)
        }.onFailure {
            Result.failure<Throwable>(it)
        }
}
