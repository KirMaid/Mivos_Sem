package com.example.mivos_sem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dishes")
data class Dishes(
    @PrimaryKey (autoGenerate = true) var id:Int? = null,
    @ColumnInfo val name_dish: String,
    @ColumnInfo val information:String
    );