package com.example.crud.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String,
)
