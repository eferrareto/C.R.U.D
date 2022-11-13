package com.example.crud

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.crud.database.App
import com.example.crud.database.Users
import com.example.crud.database.Usuarios

class RecyclerData : AppCompatActivity() {

    lateinit var rv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_data)

        //val list = mutableListOf<Users>()
        val lista = mutableListOf<Usuarios>()


        rv = findViewById(R.id.recycler)
        rv.adapter = RecyclerAdapter(lista)
        rv.layoutManager = LinearLayoutManager(this)



        lista.add(Usuarios(0, "vagabunda"))
        lista.add(Usuarios(0, "Arrobado"))
        lista.add(Usuarios(0, "Filha da Puta"))
        lista.add(Usuarios(0, "PUTA"))


    }
    inner class RecyclerAdapter(val list : MutableList<Usuarios>): RecyclerView.Adapter<RecyclerViewHolder>() {
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
    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(view : Usuarios){

            val names : TextView = itemView.findViewById(R.id.name_user)
            names.text = view.name

        }
    }
}