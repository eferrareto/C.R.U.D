package com.example.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.crud.database.App
import com.example.crud.database.Users

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var btn : Button
    lateinit var btnData : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        btn = findViewById(R.id.save)
        btnData = findViewById(R.id.data)

        btn.setOnClickListener {


            Thread{
                val app = application as App
                val dao = app.db.userDao()

                // Inserindo um novo nome
                //dao.insert(name.text.toString())


                runOnUiThread{
                    Toast.makeText(this, "Nome Salvo com sucesso", Toast.LENGTH_LONG).show()
                }
            }.start()
        }
        btnData.setOnClickListener {

            val intent = Intent(this, RecyclerData::class.java)
            intent.putExtra("id_name", name.text)
            startActivity(intent)
        }

    }
}