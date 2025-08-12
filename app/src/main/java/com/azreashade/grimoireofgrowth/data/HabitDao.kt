package com.azreashade.grimoireofgrowth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * FROM habits WHERE archived = 0 ORDER BY createdAt DESC")
    fun observeActive(): Flow<List<Habit>>

    @Insert suspend fun insert(habit: Habit): Long
    @Update suspend fun update(habit: Habit)
    @Delete suspend fun delete(habit: Habit)

    @Query("UPDATE habits SET archived = 1 WHERE id = :id")
    suspend fun archive(id: Long)
}
