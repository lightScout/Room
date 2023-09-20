package com.lightscout.room.model.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lightscout.room.model.entity.RocketLaunchDao
import com.lightscout.room.model.entity.Entity

@Database(entities = [Entity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketLaunchDao(): RocketLaunchDao
    companion object {
        // Volatile ensures the value of INSTANCE is always up-to-date and the same to all execution threads.
        // It means changes made by one thread to INSTANCE are visible to all other threads immediately.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {  // If instance is `null` then enter the synchronized block
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}