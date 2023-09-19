package com.lightscout.room.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class Root(
    val drivers: List<Driver>,
    val routes: List<Route>,
)

@Serializable
data class Driver(
    val id: String,
    val name: String,
)

@Serializable
data class Route(
    val id: Long,
    val type: String,
    val name: String,
)

