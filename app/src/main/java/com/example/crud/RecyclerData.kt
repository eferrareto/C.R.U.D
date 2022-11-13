package com.example.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.crud.database.App
import com.example.crud.database.Users

class RecyclerData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var rv : RecyclerView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_data)

        val list = mutableListOf<String>()

        Thread{
            val app = application as App
            val dao = app.db.userDao()
            val response = dao.register()
            runOnUiThread{
                list.addAll(listOf(response.toString()))
            }
        }.start()


        rv = findViewById(R.id.recycler)
        rv.adapter = RecyclerAdapter(list)
        rv.layoutManager = LinearLayoutManager(this)




    }
    inner class RecyclerAdapter(val list: MutableList<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val inflate = layoutInflater.inflate(R.layout.layout_recycler, parent, false)
            return RecyclerViewHolder(inflate)
        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            val state = list[position]
            holder.bind(state)
        }

        override fun getItemCount(): Int {
            return list.size
        }

    }
    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(view : String){

            val name : TextView = itemView.findViewById(R.id.name_user)

            name.text = view
        }
    }
}