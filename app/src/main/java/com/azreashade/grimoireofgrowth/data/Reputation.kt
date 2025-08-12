package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "reputation",
    indices = [Index(value = ["playerId","factionId"], unique = true)]
)
data class Reputation(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val playerId: Long = 1L,   // single-player for now
    val factionId: Long,
    val score: Int = 0,        // raw reputation points
    val rank: Int = 0          // derived tier
)
