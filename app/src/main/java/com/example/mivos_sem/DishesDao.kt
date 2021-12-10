package com.example.mivos_sem

import androidx.room.*

@Dao
interface DishesDao {
    @Query("DELETE FROM Dishes")
    fun deleteAll()

    @Delete
    fun delete(dish: Dishes)

    @Query("SELECT * FROM Dishes")
    fun getAll(): List<Dishes>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg dish: Dishes)

    @Update
    fun update(vararg dish: Dishes)
}