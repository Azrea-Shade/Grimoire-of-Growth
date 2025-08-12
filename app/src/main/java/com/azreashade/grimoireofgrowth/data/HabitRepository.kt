package com.azreashade.grimoireofgrowth.data

class HabitRepository(private val dao: HabitDao) {
    fun observeHabits() = dao.observeAll()
    suspend fun add(name: String, goal: Int) = dao.insert(Habit(name = name, dailyGoal = goal))
}
