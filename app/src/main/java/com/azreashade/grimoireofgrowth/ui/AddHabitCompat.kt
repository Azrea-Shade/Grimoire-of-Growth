package com.azreashade.grimoireofgrowth.ui

import android.util.Log

/**
 * TEMP IMPLEMENTATION to unblock CI. It just logs the request.
 * Replace with repository/DB call when the data layer lands.
 */
fun addHabit(
    title: String,
    notes: String? = null,
    dailyGoal: Int = 1
) {
    Log.d("AddHabitCompat", "addHabit(title=$title, goal=$dailyGoal, notes=${notes ?: ""})")
}
