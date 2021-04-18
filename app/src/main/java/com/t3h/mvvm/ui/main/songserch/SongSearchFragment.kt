package com.t3h.mvvm.ui.main.songserch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.t3h.mvvm.databinding.FragmentSearchSongBinding
import com.t3h.mvvm.model.song.Song
import com.t3h.mvvm.ui.base.BaseFragment

class SongSearchFragment : BaseFragment(), View.OnClickListener, SongSearchAdapter.ISongSearch {
    private var model: SongSearchModel? = null
    private var binding: FragmentSearchSongBinding? = null
    private val songs = mutableListOf<Song>()
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
        binding?.btnSearch?.setOnClickListener(this)
        binding?.rc?.layoutManager = GridLayoutManager(
            context,
            2
        )
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
            songs.clear()
            songs.addAll(it)
            binding?.rc?.adapter?.notifyDataSetChanged()
        })
    }

    override fun getCount() = songs.size

    override fun getData(position: Int) = songs[position]
    override fun onItemClick(position: Int) {

    }
}