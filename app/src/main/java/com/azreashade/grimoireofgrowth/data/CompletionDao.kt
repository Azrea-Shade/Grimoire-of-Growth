package com.azreashade.grimoireofgrowth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CompletionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(c: Completion): Long

    @Query("SELECT * FROM completions WHERE habitId = :habitId ORDER BY day DESC")
    fun observeByHabit(habitId: Long): Flow<List<Completion>>

    @Query("DELETE FROM completions WHERE habitId = :habitId AND day = :day")
    suspend fun deleteByDay(habitId: Long, day: Int)
}
