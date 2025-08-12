package com.azreashade.grimoireofgrowth.prefs

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

object Keys {
    val THEME = stringPreferencesKey("theme")              // "system"|"light"|"dark"
    val RESET_HOUR = intPreferencesKey("reset_hour")       // 0..23
    val HAPTICS = booleanPreferencesKey("haptics")         // on/off
}

class SettingsStore(private val context: Context) {
    val prefs = context.dataStore.data.map { it }

    suspend fun setTheme(value: String) =
        context.dataStore.edit { it[Keys.THEME] = value }

    suspend fun setResetHour(value: Int) =
        context.dataStore.edit { it[Keys.RESET_HOUR] = value }

    suspend fun setHaptics(enabled: Boolean) =
        context.dataStore.edit { it[Keys.HAPTICS] = enabled }
}
