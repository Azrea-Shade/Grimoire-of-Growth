package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "quest_steps",
    indices = [Index(value = ["questId", "orderInQuest"], unique = true)]
)
data class QuestStep(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val questId: Long,
    val orderInQuest: Int,
    // Link to a habit target (optional)
    val habitId: Long? = null,
    // Quantity goal for the step (optional)
    val requiredAmount: Int? = null,
    val done: Boolean = false
)
