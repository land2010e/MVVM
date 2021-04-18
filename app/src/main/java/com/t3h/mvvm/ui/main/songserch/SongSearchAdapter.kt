package com.t3h.mvvm.ui.main.songserch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t3h.mvvm.databinding.ItemMusicOnlineBinding
import com.t3h.mvvm.model.song.Song
import com.t3h.mvvm.ui.base.adapter.BaseAdapter

class SongSearchAdapter : RecyclerView.Adapter<SongSearchAdapter.SongSearchViewHolder>{
    private val inter: ISongSearch
    constructor(inter:ISongSearch){
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongSearchViewHolder {
        return SongSearchViewHolder(
            ItemMusicOnlineBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount()= inter.getCount()

    override fun onBindViewHolder(holder: SongSearchViewHolder, position: Int) {
        holder.binding.data =inter.getData(position)
    }

    interface ISongSearch : BaseAdapter.IBaseAdapter<Song>{
    }
    class SongSearchViewHolder(binding: ItemMusicOnlineBinding) :
        BaseAdapter.BaseViewHolder<ItemMusicOnlineBinding>(binding)
}