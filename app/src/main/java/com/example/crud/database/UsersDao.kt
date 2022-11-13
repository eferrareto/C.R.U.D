package com.example.crud.database

import androidx.room.*

@Dao
interface UsersDao {
    @Insert
    fun insert(users: String)

    @Delete
    fun delete(users: Users)

    @Query("SELECT * FROM Users WHERE id = :id")
    fun register(id : Int): List<Users>

    @Query("DELETE FROM Users")
    fun deleteAll()

    @Update
    fun update(users: Users)
}