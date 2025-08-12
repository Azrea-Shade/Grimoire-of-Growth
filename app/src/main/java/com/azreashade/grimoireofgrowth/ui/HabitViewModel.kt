package com.azreashade.grimoireofgrowth.ui

import android.app.Application
import androidx.lifecycle.*
import com.azreashade.grimoireofgrowth.data.AppDatabase
import com.azreashade.grimoireofgrowth.data.HabitRepository
import kotlinx.coroutines.launch

class HabitViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = HabitRepository(AppDatabase.getInstance(app).habitDao())
    val habits = repo.observeHabits().asLiveData()

    fun addHabit(name: String, goal: Int) {
        viewModelScope.launch { repo.add(name.trim(), goal) }
    }
}
