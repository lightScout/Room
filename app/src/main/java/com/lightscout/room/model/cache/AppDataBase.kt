package com.lightscout.room.model.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lightscout.room.model.entity.RocketLaunchDao
import com.lightscout.room.model.entity.Entity

@Database(entities = [Entity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rootDao(): RocketLaunchDao
}