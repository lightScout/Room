package com.lightscout.room.model.network

import com.lightscout.room.model.entity.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class API {

    private val httpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false

            })
        }
    }

    suspend fun getAllLaunch(): List<RocketLaunch> {
        return httpClient.get("https://api.spacexdata.com/v5/launches")
            .body()

    }
}