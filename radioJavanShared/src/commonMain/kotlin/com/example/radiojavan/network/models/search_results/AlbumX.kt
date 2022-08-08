package com.example.radiojavan.network.models.search_results


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumX(
    @SerialName("album")
    val album: String? = null,
    @SerialName("artist")
    val artist: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("share_link")
    val shareLink: String? = null,
    @SerialName("track")
    val track: Int? = null
)