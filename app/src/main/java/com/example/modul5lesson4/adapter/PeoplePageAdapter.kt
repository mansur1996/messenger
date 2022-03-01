package com.example.modul5lesson4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson4.R
import com.example.modul5lesson4.model.PeoplePage
import com.google.android.material.imageview.ShapeableImageView

class PeoplePageAdapter(var context: Context, var items: ArrayList<PeoplePage>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people_page, parent,false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val page = items[position]

        if(holder is PageViewHolder){
            holder.apply {
                iv_photo.setImageResource(page.photo)
                iv_profile.setImageResource(page.profile)
                tv_countmessage.text = page.countMessage
                tv_fullname.text = page.fullName
            }
        }

    }

    override fun getItemCount(): Int = items.size

    class PageViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var iv_photo= view.findViewById<ImageView>(R.id.iv_photo)
        var iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        var tv_countmessage = view.findViewById<TextView>(R.id.tv_count_message)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname)
    }
}