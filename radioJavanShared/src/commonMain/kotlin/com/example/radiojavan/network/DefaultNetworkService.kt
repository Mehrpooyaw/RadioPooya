package com.example.radiojavan.network

import com.example.radiojavan.network.models.request_bodies.SearchRequestBody
import com.example.radiojavan.network.models.search_results.Artist
import com.example.radiojavan.network.models.search_results.SearchResults
import com.example.radiojavan.network.models.track.Track
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.encodeToJsonElement

class DefaultNetworkService : NetworkService {
    @OptIn(InternalAPI::class)
    override suspend fun search(query: String) : SearchResults {
        return httpClient.post {
            url( "https://d1gyyseacf3czm.cloudfront.net/api2/search")
            val theBody = Json.encodeToJsonElement(SearchRequestBody(query))

            println(theBody)
            setBody(theBody)
            contentType(ContentType.Application.Json)
            contentLength()
        }.body()
    }

    override suspend fun getTrack(id: Int) : Track {
            return httpClient.get("https://d1gyyseacf3czm.cloudfront.net/api2/mp3?id=$id"){

            }.body()
    }

    @OptIn(InternalAPI::class)
    override suspend fun getArtist(query: String) : Artist {
        return httpClient.post("https://d1gyyseacf3czm.cloudfront.net/api2/artist"){
            body = SearchRequestBody(
                query
            )
            headers {
                append("content-type","Application/Json")
            }
        }.body()
    }
}

private val httpClient = HttpClient {
    install(ContentNegotiation) {
        json(jsonConfiguration)
        expectSuccess = true
    }

    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL

    }
    install(HttpTimeout){
        requestTimeoutMillis = 10000
        connectTimeoutMillis = 10000
    }



}
private val jsonConfiguration
    get() = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
        useAlternativeNames = false

    }