package com.dab.android.core.data.model.response

import com.dab.android.core.model.Album
import com.google.gson.annotations.SerializedName

data class AlbumListResponse(
    val date: String,
    @SerializedName("data")
    val album: List<AlbumResponse>?
) {
    data class AlbumResponse(
        val name: String,
        val artist: String,
        val image: String,
        val rank: Int,
        @SerializedName("last_week_rank")
        val lastWeekRank: Int,
        @SerializedName("peakRank")
        val peak_rank: Int,
        @SerializedName("weeksOnChart")
        val weeks_on_chart: Int
    )
}

fun AlbumListResponse.AlbumResponse.asAlbum() = Album(id = rank, genre = "", artist = artist, song = name, descriptions = "", imageUrl = image)
fun List<AlbumListResponse.AlbumResponse>.asAlbumList() = map { it.asAlbum() }