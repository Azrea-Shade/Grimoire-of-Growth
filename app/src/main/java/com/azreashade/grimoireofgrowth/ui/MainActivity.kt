package com.azreashade.grimoireofgrowth.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azreashade.grimoireofgrowth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private val vm: HabitViewModel by viewModels()
    private val adapter = HabitAdapter()

    private val addHabitLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { /* no-op, list auto-updates via DB observer */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.rvHabits.layoutManager = LinearLayoutManager(this)
        b.rvHabits.adapter = adapter

        b.fabAdd.setOnClickListener {
            addHabitLauncher.launch(Intent(this, AddHabitActivity::class.java))
        }

        b.btnOpenSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        vm.habits.observe(this) { list -> adapter.submit(list) }
    }
}
