package com.example.todo.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.entities.Icons

@Database(entities = [Icons::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun iconsDao(): IconDao  // Provides access to the IconDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Singleton pattern to get the database instance
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "todo_database"
                // ).allowMainThreadQueries().build()
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
