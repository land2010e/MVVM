package com.t3h.mvvm.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SongSearch")
data class SongSearch (
    @PrimaryKey
    val id: String,
    val artist: String,
    var keySearch:String = "",
    @ColumnInfo(name = "artist_ids")
    val artistIds: String?,
    val block: String,
    val disDPlatform: String,
    val disSPlatform: String,
    val disable_platform_web: String,
    val duration: String,
    @ColumnInfo(name = "genre_ids")
    val genreIds: String?,
    val hasVideo: String,
    val name: String,
    val radioPid: String,
    val streamingStatus: String,
    val thumb: String,
    val thumbVideo: String,
    val zing_choice: String
)