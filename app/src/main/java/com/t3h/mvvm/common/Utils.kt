package com.t3h.mvvm.common

import android.os.Environment
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.util.concurrent.Executors

object Utils{
    private val exDownload = Executors.newFixedThreadPool(3)
    fun downloadMp3Async(url:String, name:String){
        Observable.create<String> {
            val path = Environment.getExternalStorageDirectory().path+
                    File.separator + Environment.DIRECTORY_DOWNLOADS
                    File.separator + "music"
            File(path).mkdir()
            val out = FileOutputStream(path+File.separator+name+".mp3")
            val input = URL(url).openStream()
            val b = ByteArray(1024)
            var le = input.read(b)
            while (le >=0){
                out.write(b, 0, le)
                le = input.read(b)
            }
            out.close()
            input.close()
            it.onNext(path+File.separator+name+".mp3")
            it.onComplete()
        }
            .subscribeOn(Schedulers.from(exDownload))
            .subscribe()
    }
}