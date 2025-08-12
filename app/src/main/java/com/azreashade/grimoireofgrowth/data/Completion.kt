package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "completions",
    indices = [Index(value = ["habitId","day"], unique = true)]
)
data class Completion(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val habitId: Long,
    /** day in UTC yyyyMMdd form (e.g., 20250812) for fast queries */
    val day: Int,
    /** amount towards goal (e.g., minutes, reps, etc.) */
    val amount: Int = 1,
    val createdAt: Long = System.currentTimeMillis()
)
