package com.example.todo.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.entities.Icons

@Database(entities = [Icons::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun iconsDao(): IconDao  // Provides access to the IconDao
}
