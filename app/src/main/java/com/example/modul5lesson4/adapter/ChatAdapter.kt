package com.example.modul5lesson4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson4.R
import com.example.modul5lesson4.model.Chat
import com.example.modul5lesson4.model.Room

class ChatAdapter(var context: Context, var items : ArrayList<Chat>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]

        if(feed.rooms.size > 0) return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       if(viewType == TYPE_ITEM_ROOM){
            val view = LayoutInflater.from(context).inflate(R.layout.item_chat_room, parent, false)
           return RoomViewHolder(context, view)
       }
        val view = LayoutInflater.from(context).inflate(R.layout.item_chat_message,parent,false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]

        if(holder is RoomViewHolder){
            holder.apply {
                refreshAdapter(message.rooms, recyclerView)
            }
        }

        if(holder is MessageViewHolder){
            holder.apply {
                iv_profile.setImageResource(message.message!!.profile)
                tv_fullname.text = message.message!!.fullname
                if(message.message!!.isOnline){
                    is_online.visibility = View.VISIBLE
                }else{
                    is_online.visibility = View.GONE
                }
            }
        }

    }

    override fun getItemCount(): Int = items.size

    fun refreshAdapter(rooms : ArrayList<Room>, recyclerView: RecyclerView){
        val adapter = RoomAdapter(context, rooms)
        recyclerView.adapter = adapter
    }

    class RoomViewHolder(context: Context, view : View) : RecyclerView.ViewHolder(view){
        var recyclerView : RecyclerView = view.findViewById(R.id.recyclerView_room)

        init {
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class MessageViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var iv_profile = view.findViewById<ImageView>(R.id.iv_profile)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname)
        var is_online = view.findViewById<LinearLayout>(R.id.is_online)
    }
}