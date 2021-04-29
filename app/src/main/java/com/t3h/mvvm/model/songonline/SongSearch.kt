package com.t3h.mvvm.model.songonline

import com.t3h.mvvm.db.entity.SongSearch

data class SongSearchResponse(
    val data: MutableList<Data>,
    val result: Boolean
)

data class Data(
    val song: MutableList<SongSearch>
)
