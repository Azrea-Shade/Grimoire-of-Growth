package com.azreashade.grimoireofgrowth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ReputationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(rep: Reputation): Long

    @Query("""
        SELECT r.* FROM reputation r
        JOIN factions f ON f.id = r.factionId
        WHERE r.playerId = 1
        ORDER BY r.score DESC
    """)
    fun observePlayerReputation(): Flow<List<Reputation>>
}
