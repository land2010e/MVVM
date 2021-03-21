package com.t3h.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t3h.mvvm.databinding.ItemAoDaiBinding

class AoDaoAdapter : RecyclerView.Adapter<AoDaoAdapter.AodaiViewHolder> {
    private val inter: IAodaiAdapter

    constructor(inter: IAodaiAdapter) {
        this.inter = inter
    }

    override fun getItemCount(): Int {
        return this.inter.getCount()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : AodaiViewHolder {
        //anh xa itemview bang LayoutInflate
        //tao viewholder
        val binding = ItemAoDaiBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AodaiViewHolder(binding, inter)
    }


    override fun onBindViewHolder(
        holder: AodaiViewHolder,
        position: Int
    ) {
        //do data len xml
        holder.binding.data = inter.getData(position)

    }

    interface IAodaiAdapter {
        fun getCount(): Int
        fun getData(position: Int): AoDaiData
        fun onClickItem(position: Int)
    }

    //        class AodaiViewHolder : RecyclerView.ViewHolder {
//            private val binding: ItemAoDaiBinding
//
//            constructor(binding: ItemAoDaiBinding) : super(binding.root) {
//                this.binding = binding
//            }
//        }
    class AodaiViewHolder(
        val binding: ItemAoDaiBinding,
        inter: IAodaiAdapter
    ) : RecyclerView.ViewHolder(binding.root) {
        //goi tu dong goi sau method khoi tao
        init {
            binding.root.setOnClickListener {
                inter.onClickItem(adapterPosition)
            }
        }


    }
}