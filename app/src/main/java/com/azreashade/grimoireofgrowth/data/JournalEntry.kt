package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal_entries")
data class JournalEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val timestamp: Long = System.currentTimeMillis(),
    val mood: Int? = null,             // -2..+2 optional
    val note: String = "",
    val linkedHabitId: Long? = null
)
