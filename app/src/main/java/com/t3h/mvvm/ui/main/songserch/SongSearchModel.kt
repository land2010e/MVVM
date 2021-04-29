package com.t3h.mvvm.ui.main.songserch

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.t3h.mvvm.common.MyApp
import com.t3h.mvvm.db.entity.SongSearch
import com.t3h.mvvm.model.ZingApi
import com.t3h.mvvm.model.ZingApiUtil
import com.t3h.mvvm.model.songonline.Song
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SongSearchModel{
    val songRes = MutableLiveData<MutableList<Song>>()
    val songSearchRes = MutableLiveData<MutableList<SongSearch>>()
    private val zingApi:ZingApi
    private val zingApiSearch:ZingApi
    constructor(){
        zingApi = ZingApiUtil.createZingApi()
        zingApiSearch = ZingApiUtil.createZingApi(
            "http://ac.mp3.zing.vn"
        )
    }
    @SuppressLint("CheckResult")
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
    @SuppressLint("CheckResult")
    fun getSong(songName:String){
        zingApiSearch.getSong(songName = songName)
                //tuong tac voi internal nam tren thread nao
            .subscribeOn(Schedulers.newThread())
                //du lieu thanh cong se tra ve thread nao
            .observeOn(AndroidSchedulers.mainThread())
        //bat dau call
            .subscribe(
                {
                    //luu vao db
                    val songs = it.data[0].song
                    for (song in songs) {
                        song.keySearch = songName
                    }

                    saveSongSearch(songs)
                    //main thread
                    songSearchRes.value = songs


                },
                {
                    print("")
                    it.printStackTrace()
                    //lay tu db ra
                    val songs = MyApp.getDB().songSearchDao()
                        .getByKeySearch(songName)
                    songSearchRes.value = songs

                }
            )

    }

    @SuppressLint("CheckResult")
    private fun saveSongSearch(songs: MutableList<SongSearch>) {
        Observable.create<MutableList<SongSearch>> {
            //thuc hien
            //thuc o thread cua subscribeOn
            MyApp.getDB().songSearchDao()
                .insertAll(songs)
            //chuyen ket qua xuong thread cua observeOn
            it.onNext(songs)
            it.onComplete()
        }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                it.printStackTrace()
            })
    }
}