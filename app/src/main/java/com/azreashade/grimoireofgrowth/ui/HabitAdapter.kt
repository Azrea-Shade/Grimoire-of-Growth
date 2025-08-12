package com.azreashade.grimoireofgrowth.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azreashade.grimoireofgrowth.data.Habit
import com.azreashade.grimoireofgrowth.databinding.ListItemHabitBinding

class HabitAdapter : RecyclerView.Adapter<HabitAdapter.VH>() {
    private val items = mutableListOf<Habit>()

    fun submit(list: List<Habit>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    class VH(val b: ListItemHabitBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ListItemHabitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val h = items[position]
        holder.b.tvTitle.text = h.title
    }
    override fun getItemCount(): Int = items.size
}
