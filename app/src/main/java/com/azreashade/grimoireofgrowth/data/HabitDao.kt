package com.azreashade.grimoireofgrowth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * FROM habits ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<Habit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(habit: Habit)

    @Query("UPDATE habits SET completedToday = :done WHERE id = :id")
    suspend fun setDone(id: Long, done: Boolean)

    @Query("DELETE FROM habits WHERE id = :id")
    suspend fun deleteById(id: Long)
}
