package com.t3h.mvvm.model.songonline

data class SongSearchResponse(
    val data: MutableList<Data>,
    val result: Boolean
)

data class Data(
    val song: MutableList<SongSearch>
)

data class SongSearch(
    val artist: String,
    val artistIds: String,
    val block: String,
    val disDPlatform: String,
    val disSPlatform: String,
    val disable_platform_web: String,
    val duration: String,
    val genreIds: String,
    val hasVideo: String,
    val id: String,
    val name: String,
    val radioPid: String,
    val streamingStatus: String,
    val thumb: String,
    val thumbVideo: String,
    val zing_choice: String
)