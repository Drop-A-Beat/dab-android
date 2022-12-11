package com.dab.android.core.data.service

import com.dab.android.core.data.model.response.AlbumListResponse
import retrofit2.http.GET

interface DabService {

    @GET("KoreanThinker/billboard-json/main/billboard-hot-100/recent.json")
    suspend fun getTopAlbum(): AlbumListResponse
}