package com.azreashade.grimoireofgrowth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(faction: Faction): Long

    @Query("SELECT * FROM factions ORDER BY name")
    fun observeAll(): Flow<List<Faction>>
}
