package com.azreashade.grimoireofgrowth.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azreashade.grimoireofgrowth.data.Habit
import com.azreashade.grimoireofgrowth.databinding.ItemHabitBinding

class HabitAdapter : RecyclerView.Adapter<HabitAdapter.VH>() {
    private val items = mutableListOf<Habit>()

    fun submit(list: List<Habit>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    class VH(val b: ItemHabitBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemHabitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val h = items[position]
        holder.b.tvName.text = h.name
        holder.b.tvGoal.text = "Daily goal: ${h.dailyGoal}"
    }

    override fun getItemCount() = items.size
}
