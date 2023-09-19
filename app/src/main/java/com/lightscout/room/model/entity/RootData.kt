package com.lightscout.room.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RootData(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "list_of_drivers") val drivers: List<Driver>,
    @ColumnInfo(name = "list_of_routes") val routes: List<Route>,
) {
}