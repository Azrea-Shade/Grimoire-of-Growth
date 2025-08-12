package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val title: String,
    val createdAt: Long = System.currentTimeMillis(),
    val completedToday: Boolean = false,
    val quantity: Int = 0,
    val dailyGoal: Int = 1
)
