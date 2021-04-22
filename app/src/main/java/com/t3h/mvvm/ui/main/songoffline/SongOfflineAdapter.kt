package com.t3h.mvvm.ui.main.songoffline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t3h.mvvm.databinding.ItemMusicOfflineBinding
import com.t3h.mvvm.model.songofffline.SongOffline
import com.t3h.mvvm.ui.base.adapter.BaseAdapter

class SongOfflineAdapter : RecyclerView.Adapter<SongOfflineAdapter.SongOfflineViewHolder> {

    private val inter: ISongOffline

    constructor(inter: ISongOffline) {
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongOfflineViewHolder {
        return SongOfflineViewHolder(
            ItemMusicOfflineBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return inter.getCount()
    }

    override fun onBindViewHolder(holder: SongOfflineViewHolder, position: Int) {
        holder.binding.data = inter.getData(position)
    }

    interface ISongOffline : BaseAdapter.IBaseAdapter<SongOffline>
    class SongOfflineViewHolder(binding: ItemMusicOfflineBinding) :
        BaseAdapter.BaseViewHolder<ItemMusicOfflineBinding>(binding)
}