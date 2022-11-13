package com.example.crud.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UsersDao

    companion object{
        fun getDatabase(context : Context) : AppDataBase{

            var INSTANCE : AppDataBase? = null

            @Synchronized
            if (INSTANCE == null){
               INSTANCE = Room.databaseBuilder(
                   context.applicationContext,
                   AppDataBase::class.java,
                   "dabase.db"
               ).build()
            }
            return INSTANCE
        }

    }

}