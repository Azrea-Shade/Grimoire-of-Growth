package com.azreashade.grimoireofgrowth.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Habit::class,
        Completion::class,
        JournalEntry::class,
        Faction::class,
        Reputation::class,
        Quest::class,
        QuestStep::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun completionDao(): CompletionDao
    abstract fun journalDao(): JournalDao
    abstract fun factionDao(): FactionDao
    abstract fun reputationDao(): ReputationDao
    abstract fun questDao(): QuestDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "gog.db"
                )
                .setJournalMode(JournalMode.WRITE_AHEAD_LOGGING) // WAL = faster
                .build().also { INSTANCE = it }
            }
    }
}
