package com.t3h.mvvm.ui.main.songserch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.t3h.mvvm.common.Utils
import com.t3h.mvvm.databinding.FragmentSearchSongBinding
import com.t3h.mvvm.model.songonline.Song
import com.t3h.mvvm.db.entity.SongSearch
import com.t3h.mvvm.ui.base.BaseFragment

class SongSearchFragment : BaseFragment(), View.OnClickListener, SongSearchAdapter.ISongSearch {
    private var model: SongSearchModel? = null
    private var binding: FragmentSearchSongBinding? = null
    private val songs = mutableListOf<Song>()
    private val songSearchs = mutableListOf<SongSearch>()
    private val allSong = mutableListOf<Any>()
    private var mPlayer : MusicOnlineMediaPlayer?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchSongBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = SongSearchModel()
        mPlayer = MusicOnlineMediaPlayer()
        binding?.btnSearch?.setOnClickListener(this)
        val mrg = GridLayoutManager(
            context,
            2
        )
        mrg.spanSizeLookup = object :GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                if (getData(position) is Song){
                    return 1
                }else{
                    return 2
                }
            }
        }
        binding?.rc?.layoutManager = mrg
        binding?.rc?.adapter = SongSearchAdapter(this)
        register()
    }

    override fun onClick(v: View) {
        if ("".equals(binding?.edtSearch?.text?.toString())){
            model?.getSongFavourite()
        }else {
            model?.getSong(
                binding?.edtSearch?.text?.toString()!!
            )
        }

    }

    //register
    fun register() {
        model?.songRes?.observe(this, Observer {
            //noi nhan du lieu
            allSong.clear()
            songs.clear()
            songs.addAll(it)

            allSong.addAll(songs)
            allSong.addAll(songSearchs)
            //tron
//            allSong.shuffle()
            binding?.rc?.adapter?.notifyDataSetChanged()
        })

        model?.songSearchRes?.observe(this, Observer {
            //noi nhan du lieu
            allSong.clear()
            songSearchs.clear()
            songSearchs.addAll(it)

            //tron
            allSong.addAll(songs)
            allSong.addAll(songSearchs)
//            allSong.shuffle()
            binding?.rc?.adapter?.notifyDataSetChanged()
        })
    }

    override fun getCount():Int {
//        if (songs.size > 0 ){
//            return songs.size
//        }
//        return songSearchs.size
        return allSong.size
    }

    override fun getData(position: Int) : Any{
//        if (songs.size > 0 ){
//            return songs[position]
//        }
//        return songSearchs[position]
        return allSong[position]
    }
    override fun onItemClick(position: Int) {
        if (getData(position) is SongSearch){
            mPlayer?.setDataSource(
                "http://api.mp3.zing.vn/api/streaming/audio/${(getData(position) as SongSearch)
                    .id}/320"
            )
        }

    }

    override fun onItemClickDownload(position: Int) {
        Utils.downloadMp3Async(
            "http://api.mp3.zing.vn/api/streaming/audio/${(getData(position) as SongSearch)
                .id}/320",
            (getData(position) as SongSearch).name
        )
    }
}