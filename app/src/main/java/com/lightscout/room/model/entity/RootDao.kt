package com.lightscout.room.model.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RootDao {
    @Query("SELECT * FROM rootdata")
    fun getAll(): List<RootData>

    @Insert
    fun insertAll(vararg users: RootData)

    @Delete
    fun delete(rootData: RootData)
}