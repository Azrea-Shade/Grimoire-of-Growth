package com.azreashade.grimoireofgrowth.prefs

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

object SettingsStore {
    private val Context.dataStore by preferencesDataStore("settings")

    private val KEY_SORT = stringPreferencesKey("pref_sort")
    private val KEY_SWIPE = stringPreferencesKey("pref_swipe_action")
    private val KEY_RESET = intPreferencesKey("pref_reset_hour")

    fun sortFlow(context: Context) = context.dataStore.data.map { p: Preferences -> p[KEY_SORT] ?: "created" }
    fun swipeFlow(context: Context) = context.dataStore.data.map { p: Preferences -> p[KEY_SWIPE] ?: "none" }
    fun resetHourFlow(context: Context) = context.dataStore.data.map { p: Preferences -> p[KEY_RESET] ?: 4 }

    suspend fun setSort(context: Context, value: String) {
        context.dataStore.edit { it[KEY_SORT] = value }
    }
    suspend fun setSwipe(context: Context, value: String) {
        context.dataStore.edit { it[KEY_SWIPE] = value }
    }
    suspend fun setResetHour(context: Context, value: Int) {
        context.dataStore.edit { it[KEY_RESET] = value }
    }
}
