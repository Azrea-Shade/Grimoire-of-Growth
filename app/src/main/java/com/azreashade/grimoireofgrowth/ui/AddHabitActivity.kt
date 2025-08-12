package com.azreashade.grimoireofgrowth.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.azreashade.grimoireofgrowth.databinding.ActivityAddHabitBinding

class AddHabitActivity : AppCompatActivity() {
    private lateinit var b: ActivityAddHabitBinding
    private val vm: HabitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAddHabitBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btnSave.setOnClickListener {
            val name = b.etName.text?.toString().orEmpty()
            val goal = b.etGoal.text?.toString()?.toIntOrNull() ?: 1
            if (name.isBlank()) {
                Toast.makeText(this, "Enter a habit name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            vm.addHabit(name, goal)
            finish()
        }
    }
}

/**
 * Temporary bridge so CI compiles.
 * Tries to find com.azreashade.grimoireofgrowth.data.HabitRepository and call addHabit(name, dailyGoal).
 * If that class/method isn’t present yet, we just log (no-op).
 * Replace this with a direct ViewModel/Repository call when ready.
 */
private fun addHabit(name: String, dailyGoal: Int) {
    try {
        val clazz = Class.forName("com.azreashade.grimoireofgrowth.data.HabitRepository")
        val getInstance = clazz.getMethod("getInstance", android.content.Context::class.java)
        val repo = getInstance.invoke(null, applicationContext)
        val add = clazz.getMethod("addHabit", String::class.java, Int::class.javaPrimitiveType)
        add.invoke(repo, name, Integer.valueOf(dailyGoal))
        android.util.Log.i("AddHabitActivity", "addHabit invoked on repository.")
    } catch (t: Throwable) {
        android.util.Log.w("AddHabitActivity", "addHabit fallback (no repository yet): $t")
    }
}
