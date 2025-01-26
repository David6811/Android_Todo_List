package com.example.todo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "icons")
data class Icons(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") val id: Int = 0,
    val name: String?,
    val image: Int?
)