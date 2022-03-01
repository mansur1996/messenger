package com.example.modul5lesson4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson4.R
import com.example.modul5lesson4.model.Room
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(var context: Context, var items : ArrayList<Room>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent,false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]

        if(holder is RoomViewHolder){
            holder.apply {
                iv_profile.setImageResource(room.profile)
                tv_fullname.text = room.fullname
            }
        }

    }

    override fun getItemCount(): Int = items.size

    class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname)
    }
}