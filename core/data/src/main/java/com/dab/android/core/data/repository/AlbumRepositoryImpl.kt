package com.dab.android.core.data.repository

import com.dab.android.core.data.RemoteException
import com.dab.android.core.data.datasource.DabDataSource
import com.dab.android.core.data.mapper.DabMapper
import com.dab.android.core.data.mapper.ErrorMapper
import com.dab.android.core.domain.repository.AlbumRepository
import com.dab.android.core.model.Album
import com.dab.android.core.model.base.Record
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val dabDataSource: DabDataSource
): AlbumRepository {
    private val dabMapper = DabMapper()
    private val errorMapper = ErrorMapper()

    override suspend fun getAlbum(): Record<List<Album>> {
        return try {
            dabDataSource.getTopAlbum().getOrThrow().let {
                dabMapper.mapAlbumResponse(it)
            }
        } catch(e: RemoteException) {
            errorMapper.mapErrorRecord(e)
        }
    }
}