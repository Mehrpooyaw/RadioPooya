package com.example.radiojavan.network.models.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
    @SerialName("bg_color")
    val bgColor: String?,
    @SerialName("bg_colors")
    val bgColors: List<String?>?,
    @SerialName("count")
    val count: Int?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("created_by")
    val createdBy: String?,
    @SerialName("custom_photo")
    val customPhoto: Boolean?,
    @SerialName("followers")
    val followers: Int?,
    @SerialName("id")
    val id: String?,
    @SerialName("items_count")
    val itemsCount: Int?,
    @SerialName("last_updated_at")
    val lastUpdatedAt: String?,
    @SerialName("myplaylist")
    val myplaylist: Boolean?,
    @SerialName("photo")
    val photo: String?,
    @SerialName("photo_player")
    val photoPlayer: String?,
    @SerialName("public")
    val `public`: Boolean?,
    @SerialName("share_link")
    val shareLink: String?,
    @SerialName("subtype")
    val subtype: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String?
)