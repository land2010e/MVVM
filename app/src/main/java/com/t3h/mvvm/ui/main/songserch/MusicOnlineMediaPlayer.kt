package com.t3h.mvvm.ui.main.songserch

import android.media.MediaPlayer
import android.util.Log

class MusicOnlineMediaPlayer : MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener,
    MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {
    private var mp: MediaPlayer? = null
    fun setDataSource(path: String) {
        release()
        mp = MediaPlayer()
        mp?.setOnErrorListener(this)
        mp?.setOnCompletionListener(this)
        mp?.setDataSource(path)
        mp?.setOnPreparedListener(this)
        mp?.setOnBufferingUpdateListener(this)
        mp?.prepareAsync()
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return true
    }

    override fun onCompletion(mp: MediaPlayer?) {

    }

    override fun onPrepared(mp: MediaPlayer?) {
        start()
    }

    fun start() {
        mp?.start()
    }

    fun pause() {
        mp?.pause()
    }

    fun stop() {
        mp?.stop()
    }

    fun release() {
        mp?.release()
    }

    override fun onBufferingUpdate(mp: MediaPlayer?, percent: Int) {
        Log.d("MusicOnlineMediaPlayer", "onBufferingUpdate percent: ${percent}")
    }
}