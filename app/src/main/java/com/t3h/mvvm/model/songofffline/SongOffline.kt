package com.t3h.mvvm.model.songofffline

import java.util.*

data class SongOffline(
    var name:String,
    var artist:String,
    var pathImage:String?,
    var lastModifier:Date?,
    var path:String
)