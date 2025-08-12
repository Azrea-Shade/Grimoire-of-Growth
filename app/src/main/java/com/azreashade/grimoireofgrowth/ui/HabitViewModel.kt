package com.azreashade.grimoireofgrowth.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.azreashade.grimoireofgrowth.data.HabitRepository
import kotlinx.coroutines.launch

class HabitViewModel(app: Application): AndroidViewModel(app) {
    private val repo = HabitRepository.from(app)
    val habits = repo.observeAll().asLiveData()

    fun addSample() = viewModelScope.launch {
        repo.addOrUpdate("Sample habit", 1)
    }
}
