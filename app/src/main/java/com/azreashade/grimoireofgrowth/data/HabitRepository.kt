package com.azreashade.grimoireofgrowth.data

import android.content.Context
import kotlinx.coroutines.flow.Flow

class HabitRepository(private val dao: HabitDao) {

    fun observeAll(): Flow<List<Habit>> = dao.observeAll()

    suspend fun addOrUpdate(title: String, dailyGoal: Int = 1) {
        dao.upsert(Habit(title = title, dailyGoal = dailyGoal))
    }

    suspend fun setDone(id: Long, done: Boolean) = dao.setDone(id, done)

    suspend fun delete(id: Long) = dao.deleteById(id)

    companion object {
        fun from(context: Context) = HabitRepository(AppDatabase.getInstance(context).habitDao())
    }
}
