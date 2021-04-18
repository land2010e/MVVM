package com.t3h.mvvm.ui.main.songserch

import androidx.lifecycle.MutableLiveData
import com.t3h.mvvm.model.ZingApi
import com.t3h.mvvm.model.ZingApiUtil
import com.t3h.mvvm.model.song.Song
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SongSearchModel{
    val songRes = MutableLiveData<MutableList<Song>>()
    private val zingApi:ZingApi
    private val zingApiSearch:ZingApi
    constructor(){
        zingApi = ZingApiUtil.createZingApi()
        zingApiSearch = ZingApiUtil.createZingApi(
            "http://ac.mp3.zing.vn"
        )
    }
    fun getSongFavourite(){
        zingApi.getAllSong()
                //tuong tac voi internal nam tren thread nao
            .subscribeOn(Schedulers.newThread())
                //du lieu thanh cong se tra ve thread nao
            .observeOn(AndroidSchedulers.mainThread())
        //bat dau call
            .subscribe(
                {
                    songRes.value = it.data!!.song
                },
                {
                    print("")

                }
            )

    }
    fun getSong(songName:String){
        zingApiSearch.getSong(songName = songName)
                //tuong tac voi internal nam tren thread nao
            .subscribeOn(Schedulers.newThread())
                //du lieu thanh cong se tra ve thread nao
            .observeOn(AndroidSchedulers.mainThread())
        //bat dau call
            .subscribe(
                {
                    songRes.value = it.data!!.song
                },
                {
                    print("")

                }
            )

    }
}