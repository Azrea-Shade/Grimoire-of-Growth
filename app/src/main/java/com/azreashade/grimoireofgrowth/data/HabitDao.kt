package com.azreashade.grimoireofgrowth.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HabitDao {
    @Query("SELECT * FROM habits")
    fun getAll(): List<Habit>

    @Insert
    suspend fun insert(habit: Habit)
}
