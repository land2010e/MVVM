package com.t3h.mvvm.model.song

data class ZingResponse(
    var err: Int = 0,
    var msg: String = "",
    var data: ZingData? = null
) {

}

data class ZingData(
    var song: MutableList<Song>
)

data class Song(
    var id: String = "",
    var name: String = "",
    var title: String = "",
    var code: String = "",
    var duration: Int = 0,
    var total: Int = 0,
    var artist: Artist? = null
)

data class Artist(
    var id: String = "",
    var name: String = "",
    var thumbnail: String = ""
)