package com.lightscout.room.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(
    @PrimaryKey val id: Int,
    val missionName: String,
    val launchDateUTC: String,
    val details: String?,
    val launchSuccess: Boolean?,
    val links: String?
)
