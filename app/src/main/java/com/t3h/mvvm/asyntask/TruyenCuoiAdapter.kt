package com.t3h.mvvm.asyntask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t3h.mvvm.databinding.TruyenCuoiItemBinding

class TruyenCuoiAdapter : RecyclerView.Adapter<TruyenCuoiAdapter.TruyenCuoiHolder> {
    private val inter: ITruyenCuoi

    constructor(inter: ITruyenCuoi) {
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TruyenCuoiHolder {
        return TruyenCuoiHolder(
            TruyenCuoiItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ),
            inter
        )
    }

    override fun getItemCount() = inter.getCount()

    override fun onBindViewHolder(holder: TruyenCuoiHolder, position: Int) {
        holder.binding.data = inter.getData(position)
    }

    interface ITruyenCuoi {
        fun getCount(): Int
        fun getData(position: Int): TruyenCuoiData
        fun onItemClick(position: Int)
    }

    class TruyenCuoiHolder(
        val binding: TruyenCuoiItemBinding,
        inter: ITruyenCuoi
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                inter.onItemClick(adapterPosition)
            }
        }
    }
}