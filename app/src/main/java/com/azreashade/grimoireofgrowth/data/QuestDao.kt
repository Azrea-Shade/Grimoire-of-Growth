package com.azreashade.grimoireofgrowth.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

data class QuestWithSteps(
    @Embedded val quest: Quest,
    @Relation(parentColumn = "id", entityColumn = "questId")
    val steps: List<QuestStep>
)

@Dao
interface QuestDao {
    @Insert suspend fun insertQuest(q: Quest): Long
    @Insert suspend fun insertStep(s: QuestStep): Long

    @Transaction
    @Query("SELECT * FROM quests WHERE status != 'done' ORDER BY createdAt DESC")
    fun observeOpen(): Flow<List<QuestWithSteps>>

    @Query("UPDATE quests SET status = :status WHERE id = :id")
    suspend fun setStatus(id: Long, status: String)

    @Query("UPDATE quest_steps SET done = :done WHERE id = :id")
    suspend fun setStepDone(id: Long, done: Boolean)
}
