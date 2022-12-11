package com.dab.android.core.model

data class Album(
    val id: Int,
    val genre: String,
    val artist: String,
    val song: String,
    val descriptions: String,
    val imageUrl: String
)