package com.lightscout.room.model.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lightscout.room.model.entity.RootDao
import com.lightscout.room.model.entity.Drivers

@Database(entities = [Drivers::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rootDao(): RootDao
}