package com.lightscout.room.model.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RocketLaunchDao {
    @Query("SELECT * FROM  entity")
    fun getAllLaunch(): List<Entity>

    @Insert
    fun insertAllLaunch(vararg users: Entity)

    @Query("DELETE FROM entity")
    fun deleteLaunch()
}