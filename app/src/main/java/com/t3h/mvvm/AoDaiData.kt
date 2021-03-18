package com.t3h.mvvm

data class AoDaiData(
    val imageId: Int,
    val name: String,
    val lastMessage: String,
    var isClick:Boolean=false
)