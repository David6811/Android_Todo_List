package com.example.todo.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.entities.Icons

@Dao
interface IconDao {
    @Insert
    suspend fun insertAll(users: Array<Icons>)

    @Delete
    fun delete(icons: Icons)

    @Query("SELECT * FROM icons")
    suspend fun getAll(): List<Icons>

    @Query("DELETE FROM icons")
    suspend fun deleteAll()

    @Query("DELETE FROM icons WHERE rowid = :iconId")
    suspend fun deleteItemById(iconId: Int)
}