package com.example.mivos_sem

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase





@Database(entities = [Dishes::class],version = 1)
abstract class DishesDatabase : RoomDatabase() {
    abstract fun DishesDao(): DishesDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DishesDatabase? = null

        fun getDatabase(context: Context): DishesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    DishesDatabase::class.java,
                    "Dishes.db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

//class DatabaseDishes {
//}