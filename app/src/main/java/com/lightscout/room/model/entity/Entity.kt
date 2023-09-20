package com.lightscout.room.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(
    @PrimaryKey val id: Int,
    val missionName: String,
)
