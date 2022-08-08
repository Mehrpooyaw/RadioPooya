package com.example.radiojavan.network.models.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("albums")
    val albums: List<Album>?,
    @SerialName("background")
    val background: String?,
    @SerialName("bg_colors")
    val bgColors: List<String>?,
//    @SerialName("events")
//    val events: List<Any>?,
    @SerialName("followers")
    val followers: Followers?,
    @SerialName("latest")
    val latest: Latest?,
    @SerialName("mp3s")
    val mp3s: List<Mp3>?,
    @SerialName("photo")
    val photo: String?,
    @SerialName("photo_player")
    val photoPlayer: String?,
    @SerialName("photo_thumb")
    val photoThumb: String?,
//    @SerialName("photos")
//    val photos: List<Any>?,
    @SerialName("playlists")
    val playlists: List<Playlists>?,
//    @SerialName("podcasts")
//    val podcasts: List<Any>?,
//    @SerialName("prereleases")
//    val prereleases: List<Any>?,
    @SerialName("query")
    val query: String?,
    @SerialName("share_link")
    val shareLink: String?,
//    @SerialName("videos")
//    val videos: List<Any>?
)