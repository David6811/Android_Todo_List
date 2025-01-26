package com.example.todo.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.entities.Icons

@Dao
interface IconDao {
    @Insert
    fun insertAll(users: Array<Icons>)

    @Delete
    fun delete(icons: Icons)

    @Query("SELECT * FROM icons")
    fun getAll(): List<Icons>

    @Query("DELETE FROM icons")
    fun deleteAll()
}