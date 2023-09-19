package com.lightscout.room.model.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RootDao {
    @Query("SELECT * FROM  drivers")
    fun getAllDrivers(): List<Drivers>

    @Insert
    fun insertAllDrivers(vararg users: Drivers)

    @Delete
    fun deleteDriver(driver: Drivers)
}