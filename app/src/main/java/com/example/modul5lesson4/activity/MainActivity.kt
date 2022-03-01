package com.example.modul5lesson4.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson4.R
import com.example.modul5lesson4.adapter.ChatAdapter
import com.example.modul5lesson4.adapter.PeoplePageAdapter
import com.example.modul5lesson4.model.Chat
import com.example.modul5lesson4.model.Message
import com.example.modul5lesson4.model.PeoplePage
import com.example.modul5lesson4.model.Room

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.peoplepage_layout)
//        initViewsMain()
        initViewsMainPeoplePage()
    }

    private fun initViewsMainPeoplePage(){
        val recyclerView = findViewById<RecyclerView>(R.id.rv_people_page)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = PeoplePageAdapter(this, getAllPeoplePages())
    }

    private fun getAllPeoplePages(): ArrayList<PeoplePage>{
        val pages : ArrayList<PeoplePage> = ArrayList()

        pages.add(PeoplePage(R.drawable.img_fashion_2, R.drawable.ic_baseline_add_24, "1", "Add to Story"))

        for(i in 1..6){
            pages.add(PeoplePage(R.drawable.img_profile, R.drawable.img_fashion_1, "${i}", "Obodova Malika"))
            pages.add(PeoplePage(R.drawable.img_fashion_2, R.drawable.img_fashion_1, "${i%3+1}", "Egamova Elinora"))
        }
        return pages
    }

    private fun initViewsMain(){
        recyclerView = findViewById(R.id.recyclerViewMain)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats : ArrayList<Chat>){
        val adapter = ChatAdapter(this, chats)
        recyclerView.adapter = adapter
    }

    private fun getAllChats() : ArrayList<Chat>{
        val stories : ArrayList<Room> = ArrayList()

        stories.add(Room(R.drawable.ic_baseline_video_call_24, "Create room"))
        for(i in 1..15){
            stories.add(Room(R.drawable.img_profile, "Malika Odobova$i"))
        }

        val chats : ArrayList<Chat> = ArrayList()
        //Room
        chats.add(Chat(stories))

        for(i in 0..15){
            chats.add(Chat(Message(R.drawable.img_profile, "Malika Obidova$i")))
        }
        return chats
    }
}