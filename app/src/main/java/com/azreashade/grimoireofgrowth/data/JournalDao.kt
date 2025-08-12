package com.azreashade.grimoireofgrowth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Insert suspend fun insert(entry: JournalEntry): Long
    @Query("SELECT * FROM journal_entries ORDER BY timestamp DESC LIMIT :limit")
    fun recent(limit: Int = 100): Flow<List<JournalEntry>>
}
