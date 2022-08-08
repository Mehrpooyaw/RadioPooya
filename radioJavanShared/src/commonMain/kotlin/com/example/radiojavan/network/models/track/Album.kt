package com.example.radiojavan.network.models.track


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Album(
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