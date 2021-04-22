package com.t3h.mvvm.model.songofffline

import android.net.Uri
import java.util.*

data class SongOffline(
    var name:String,
    var artist:String,
    var pathImage:Uri?,
    var lastModifier:Date?,
    var path:String
)