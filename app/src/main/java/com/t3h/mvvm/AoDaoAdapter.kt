package com.t3h.mvvm

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AoDaoAdapter : RecyclerView.Adapter<AoDaoAdapter.AodaiViewHolder> {
    private val aodais: MutableList<AoDaiData>

    constructor(aodais: MutableList<AoDaiData>) {
        this.aodais = aodais
    }

    override fun getItemCount(): Int {
        return aodais.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : AodaiViewHolder {
        //anh xa itemview bang LayoutInflate
        //tao viewholder
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_ao_dai,
                parent,
                false
            )
        return AodaiViewHolder(itemView)
    }


    override fun onBindViewHolder(
        holder: AodaiViewHolder,
        position: Int
    ) {
        val data = aodais[position]
        //anh xa
        val iv: ImageView = holder.itemView.findViewById<ImageView>(R.id.iv_img)
        val tvUsername: TextView = holder.itemView.findViewById<TextView>(R.id.tv_name)
        val tvLastMessage: TextView = holder.itemView.findViewById<TextView>(R.id.tv_last_message)

        //do du lieu len
        iv.setImageResource(data.imageId)
        tvUsername.setText(data.name)
        tvLastMessage.setText(data.lastMessage)
        if (data.isClick){
            holder.itemView.setBackgroundColor(Color.CYAN)
        }else {
            holder.itemView.setBackgroundColor(Color.WHITE)
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View) {
                v.setBackgroundColor(Color.CYAN)
                data.isClick=true

                //tao intent
                val intent = Intent()
                intent.putExtra("CONTENT", data.name)
                intent.setClass(v.context, ViewAcitivity::class.java)
                v.context.startActivity(intent)
            }
        })

    }

    class AodaiViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View) : super(itemView) {
        }
    }


}