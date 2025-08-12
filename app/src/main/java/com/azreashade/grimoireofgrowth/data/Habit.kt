package com.azreashade.grimoireofgrowth.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "habits",
    indices = [
        Index(value = ["createdAt"]),
        Index(value = ["name"])
    ]
)
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    val dailyGoal: Int,
    val createdAt: Long = System.currentTimeMillis()
)
