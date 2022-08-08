package com.example.radiojavan.network.models.video


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Related(
    @SerialName("artist")
    val artist: String?,
    @SerialName("artist_farsi")
    val artistFarsi: String?,
    @SerialName("artist_tags")
    val artistTags: List<String?>?,
    @SerialName("bg_colors")
    val bgColors: List<String?>?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("dislikes")
    val dislikes: String?,
    @SerialName("explicit")
    val explicit: Boolean?,
    @SerialName("high")
    val high: String?,
    @SerialName("high_web")
    val highWeb: String?,
    @SerialName("hls")
    val hls: String?,
    @SerialName("hq_link")
    val hqLink: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("likes")
    val likes: String?,
    @SerialName("link")
    val link: String?,
    @SerialName("low")
    val low: String?,
    @SerialName("low_web")
    val lowWeb: String?,
    @SerialName("lq_link")
    val lqLink: String?,
    @SerialName("permlink")
    val permlink: String?,
    @SerialName("photo")
    val photo: String?,
    @SerialName("photo_large")
    val photoLarge: String?,
    @SerialName("photo_player")
    val photoPlayer: String?,
    @SerialName("share_link")
    val shareLink: String?,
    @SerialName("song")
    val song: String?,
    @SerialName("song_farsi")
    val songFarsi: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("views")
    val views: String?
)