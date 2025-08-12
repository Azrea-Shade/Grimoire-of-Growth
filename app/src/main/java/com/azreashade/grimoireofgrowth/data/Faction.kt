package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "factions")
data class Faction(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val key: String,      // e.g., "monks", "guards"
    val name: String,     // display name
    val blurb: String = ""
)
