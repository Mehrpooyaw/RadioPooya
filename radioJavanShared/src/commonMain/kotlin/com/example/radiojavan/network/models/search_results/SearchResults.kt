package com.example.radiojavan.network.models.search_results


import kotlinx.serialization.Contextual
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResults(
//    @SerialName("albums")
//    val albums: List<Album>? = listOf(),
//    @SerialName("all_artists")
//    val allArtists: List<AllArtist>? = listOf(),
//    @SerialName("artists")
//    val artists: List<Artist>? = listOf(),
//    @SerialName("lyrics")
//    val lyrics: List<@Contextual Any>? = listOf(),
    @SerialName("mp3s")
    val mp3s: List<Mp3>? = listOf(),
//    @SerialName("playlists")
//    val playlists: List< @Contextual Any>? = listOf(),
//    @SerialName("podcasts")
//    val podcasts: List<Podcast>? = listOf(),
//    @SerialName("profiles")
//    val profiles: List<@Contextual Any>? = listOf(),
//    @SerialName("query")
//    val query: String? = "",
//    @SerialName("shows")
//    val shows: List<@Contextual Any>? = listOf(),
//    @SerialName("videos")
//    val videos: List<Video>? = listOf()
)