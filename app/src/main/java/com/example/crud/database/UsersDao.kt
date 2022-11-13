package com.example.crud.database

import androidx.room.*

@Dao
interface UsersDao {
    @Insert
    fun insert(users: Users)

    @Delete
    fun delete(users: Users)

    @Query("SELECT * FROM Users")
    fun register(): List<Users>

    @Query("DELETE FROM Users")
    fun deleteAll()

    @Update
    fun update(users: Users)
}