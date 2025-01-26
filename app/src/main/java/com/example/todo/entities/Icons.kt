package com.example.todo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "icons")
data class Icons(
    @PrimaryKey @ColumnInfo(name = "rowid") val id: Int,
    val name: String?,
    val image: Int?
)