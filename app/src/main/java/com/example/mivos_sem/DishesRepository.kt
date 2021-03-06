package com.example.mivos_sem

import androidx.annotation.WorkerThread

class DishesRepository (private val dishesDao: DishesDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allDishes = dishesDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dish: Dishes) {
        dishesDao.insert(dish)
    }
}
