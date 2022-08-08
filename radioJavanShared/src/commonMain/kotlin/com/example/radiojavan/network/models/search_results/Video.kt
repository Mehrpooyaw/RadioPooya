package com.example.radiojavan.network.models.search_results


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Video(
    @SerialName("artist")
    val artist: String? = null,
    @SerialName("artist_farsi")
    val artistFarsi: String? = null,
    @SerialName("artist_tags")
    val artistTags: List<String?>? = null,
    @SerialName("bg_colors")
    val bgColors: List<String?>? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("dislikes")
    val dislikes: String? = null,
    @SerialName("explicit")
    val explicit: Boolean? = null,
    @SerialName("high")
    val high: String? = null,
    @SerialName("high_web")
    val highWeb: String? = null,
    @SerialName("hls")
    val hls: String? = null,
    @SerialName("hq_link")
    val hqLink: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("likes")
    val likes: String? = null,
    @SerialName("link")
    val link: String? = null,
    @SerialName("low")
    val low: String? = null,
    @SerialName("low_web")
    val lowWeb: String? = null,
    @SerialName("lq_link")
    val lqLink: String? = null,
    @SerialName("permlink")
    val permlink: String? = null,
    @SerialName("photo")
    val photo: String? = null,
    @SerialName("photo_large")
    val photoLarge: String? = null,
    @SerialName("photo_player")
    val photoPlayer: String? = null,
    @SerialName("share_link")
    val shareLink: String? = null,
    @SerialName("song")
    val song: String? = null,
    @SerialName("song_farsi")
    val songFarsi: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("views")
    val views: String? = null
)