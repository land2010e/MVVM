package com.t3h.mvvm.ui.test.fragment.store

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.t3h.mvvm.ui.base.BaseFragment
import com.t3h.mvvm.databinding.FragmentInfoStoreBinding

class InfoStoreFragment : BaseFragment(), MediaPlayer.OnErrorListener,
    MediaPlayer.OnPreparedListener {
    private var binding: FragmentInfoStoreBinding? = null

    //    private lateinit var binding:FragmentInfoStoreBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoStoreBinding.inflate(
            inflater, container, false
        )

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.tvImg.setText(countImageInDevice().toString())
        binding!!.tvVideo.setText(countVideoInDevice().toString())
        getAllMusic()
        playMudic()
    }

    fun countImageInDevice(): Int {
        //uri la tem va duong dan dan den bang
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//        contentResolver duoc lay tu context
        val projection = arrayOf("count(*) as c", "max(_id) as mID")
        val cursor = context!!.contentResolver.query(
            uri, projection,
            null, null, null
        )
        if (cursor == null) {
            return 0
        }
        cursor.moveToFirst()
        var count = 0
        while (!cursor.isAfterLast) {
            count = cursor.getInt(
                cursor.getColumnIndex("c")
            )
            cursor.moveToNext()
        }
        return count
    }

    fun countVideoInDevice(): Int {
        //uri la tem va duong dan dan den bang
        val uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
//        contentResolver duoc lay tu context
        val projection = arrayOf("count(*) as c", "max(_id) as mID")
        val cursor = context!!.contentResolver.query(
            uri, projection,
            null, null, null
        )
        if (cursor == null) {
            return 0
        }
        cursor.moveToFirst()
        var count = 0
        while (!cursor.isAfterLast) {
            count = cursor.getInt(
                cursor.getColumnIndex("c")
            )
            cursor.moveToNext()
        }
        return count
    }

    private fun getAllMusic(){
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val cur = context!!.contentResolver.query(uri, null, null, null, null)
        cur!!.moveToFirst()
        val indexData = cur.getColumnIndex(MediaStore.Audio.Media.DATA)
        val indexTitle = cur.getColumnIndex(MediaStore.Audio.Media.TITLE)
        val indexMintype = cur.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE)
        while (!cur.isAfterLast){
            val path = cur.getString(indexData)
            val title = cur.getString(indexTitle)
            val minty = cur.getString(indexMintype)
            cur.moveToNext()
            Log.d("getAllMusic", "getAllMusic path: "+path)
            Log.d("getAllMusic", "getAllMusic title: "+title)
            Log.d("getAllMusic", "getAllMusic minty: "+minty)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun playMudic(){
        val mp = MediaPlayer()
        mp.setOnErrorListener(this)
        mp.setDataSource("http://api.mp3.zing.vn/api/streaming/audio/ZOACFBBU/320")
        mp.setOnPreparedListener(this)
        mp.prepareAsync()
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return true
    }

    override fun onPrepared(mp: MediaPlayer) {
        mp.start()
    }
}