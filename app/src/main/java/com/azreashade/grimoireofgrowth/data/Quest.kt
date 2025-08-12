package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "quests",
    indices = [Index(value = ["status"]), Index(value = ["factionId"])]
)
data class Quest(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val title: String,
    val description: String = "",
    val factionId: Long? = null,
    val status: String = "open",   // open | active | done | failed
    val createdAt: Long = System.currentTimeMillis()
)
