package com.lightscout.room.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Drivers(
    @PrimaryKey val id: Int,
    val driver: String,
)
