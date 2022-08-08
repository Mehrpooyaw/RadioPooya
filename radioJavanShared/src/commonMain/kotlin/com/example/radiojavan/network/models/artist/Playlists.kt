package com.example.radiojavan.network.models.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Playlists(
    @SerialName("hide_name")
    val hideName: Boolean?,
    @SerialName("name")
    val name: String?,
    @SerialName("playlist")
    val playlist: Playlist?
)