package com.t3h.mvvm.ui.main.songserch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t3h.mvvm.databinding.ItemMusicOnlineBinding
import com.t3h.mvvm.databinding.ItemMusicOnlineSearchBinding
import com.t3h.mvvm.db.entity.SongSearch
import com.t3h.mvvm.model.songonline.Song
import com.t3h.mvvm.ui.base.adapter.BaseAdapter

class SongSearchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private val inter: ISongSearch
    constructor(inter:ISongSearch){
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerView.ViewHolder {
        if ( viewType == 1){
            return SongSearchViewHolder(
                ItemMusicOnlineBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
        }else {
            return SongViewHolder(
                ItemMusicOnlineSearchBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
        }

    }

    override fun getItemCount()= inter.getCount()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SongSearchViewHolder){
            (holder as SongSearchViewHolder).binding.data =inter.getData(position) as Song
        }else {
            (holder as SongViewHolder).binding.data = inter.getData(position) as SongSearch
            (holder as SongViewHolder).binding.btnDownload.setOnClickListener {
                inter.onItemClickDownload(position)
            }
        }
        holder.itemView.setOnClickListener {
            inter.onItemClick(position)
        }

    }

    override fun getItemViewType(position: Int): Int {
        if ( inter.getData(position) is Song){
            return 1
        }else {
            return 2
        }
    }

    interface ISongSearch : BaseAdapter.IBaseAdapter<Any>{
        fun onItemClickDownload(position:Int)
    }

    class SongSearchViewHolder(binding: ItemMusicOnlineBinding) :
        BaseAdapter.BaseViewHolder<ItemMusicOnlineBinding>(binding)

    class SongViewHolder(binding: ItemMusicOnlineSearchBinding) :
        BaseAdapter.BaseViewHolder<ItemMusicOnlineSearchBinding>(binding)
}