package com.t3h.mvvm.ui.test.fragment.store

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t3h.mvvm.databinding.ExternalStoreItemBinding

class ExternalStoreAdapter : RecyclerView.Adapter<ExternalStoreAdapter.ExternalStoreViewHolder> {

    private val inter: IExternalStore

    constructor(inter: IExternalStore) {
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExternalStoreViewHolder {
        return ExternalStoreViewHolder(
            ExternalStoreItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ),
            inter
        )
    }

    override fun getItemCount() = this.inter.getCount()

    override fun onBindViewHolder(holder: ExternalStoreViewHolder, position: Int) {
        holder.binding.data = inter.getData(position)
    }

    interface IExternalStore {
        fun getCount(): Int
        fun getData(position: Int): FolderInfo
        fun onClickItem(position: Int)
    }

    class ExternalStoreViewHolder(
        val binding: ExternalStoreItemBinding,
        inter: IExternalStore
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                inter.onClickItem(adapterPosition)
            }
        }
    }
}