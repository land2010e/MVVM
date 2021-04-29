package com.t3h.mvvm.ui.main.songoffline

import android.media.MediaPlayer

class MusicOfflinePlayer : MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    private var mp: MediaPlayer? = null
    var complete: (() -> Unit)? = null


    fun setDataSource(path: String) {
        release()
        mp = MediaPlayer()
        mp?.setOnErrorListener(this)
        mp?.setOnCompletionListener(this)
        mp?.setDataSource(path)
        mp?.prepare()
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return true
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

    override fun onCompletion(mp: MediaPlayer) {
        complete?.invoke()
    }
}