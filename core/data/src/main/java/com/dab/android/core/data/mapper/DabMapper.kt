package com.dab.android.core.data.mapper

import com.dab.android.core.data.model.response.AlbumListResponse
import com.dab.android.core.data.model.response.asAlbumList
import com.dab.android.core.model.Album
import com.dab.android.core.model.base.Record

class DabMapper {
    fun mapAlbumResponse(albumListResponse: AlbumListResponse): Record<List<Album>> {
        return albumListResponse.run {
            album?.let {
                Record(it.asAlbumList())
            }?:run{ Record(emptyList()) }
        }
    }
}