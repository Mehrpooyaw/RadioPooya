package com.example.radiojavan.network.models.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumX(
    @SerialName("album")
    val album: String?,
    @SerialName("artist")
    val artist: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("share_link")
    val shareLink: String?,
    @SerialName("track")
    val track: Int?
)