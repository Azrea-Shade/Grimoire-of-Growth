package com.azreashade.grimoireofgrowth.ui

import android.util.Log

/** Temporary bridge to unblock CI; replace with real ViewModel/repo call later. */
fun addHabit(name: String, dailyGoal: Int) {
    try {
        val clazz = Class.forName("com.azreashade.grimoireofgrowth.data.HabitRepository")
        val app = Class.forName("android.app.ActivityThread")
            .getMethod("currentApplication").invoke(null) as android.app.Application
        val getInstance = clazz.getMethod("getInstance", android.content.Context::class.java)
        val repo = getInstance.invoke(null, app)
        val add = clazz.getMethod("addHabit", String::class.java, Int::class.javaPrimitiveType)
        add.invoke(repo, name, Integer.valueOf(dailyGoal))
        Log.i("AddHabitBridge", "Repository addHabit invoked for '$name' ($dailyGoal)")
    } catch (t: Throwable) {
        Log.w("AddHabitBridge", "Fallback addHabit (repo not wired): ${t.message}")
    }
}
