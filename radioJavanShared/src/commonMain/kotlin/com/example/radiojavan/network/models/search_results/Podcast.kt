package com.example.radiojavan.network.models.search_results


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Podcast(
    @SerialName("bg_colors")
    val bgColors: List<String?>? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("date")
    val date: String? = null,
    @SerialName("date_added")
    val dateAdded: String? = null,
    @SerialName("dislikes")
    val dislikes: String? = null,
    @SerialName("duration")
    val duration: Double? = null,
    @SerialName("explicit")
    val explicit: Boolean? = null,
    @SerialName("hls_link")
    val hlsLink: String? = null,
    @SerialName("hq_hls")
    val hqHls: String? = null,
    @SerialName("hq_link")
    val hqLink: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("likes")
    val likes: String? = null,
    @SerialName("link")
    val link: String? = null,
    @SerialName("lq_hls")
    val lqHls: String? = null,
    @SerialName("lq_link")
    val lqLink: String? = null,
    @SerialName("lufs")
    val lufs: Double? = null,
    @SerialName("permlink")
    val permlink: String? = null,
    @SerialName("photo")
    val photo: String? = null,
    @SerialName("photo_240")
    val photo240: String? = null,
    @SerialName("photo_large")
    val photoLarge: String? = null,
    @SerialName("photo_player")
    val photoPlayer: String? = null,
    @SerialName("plays")
    val plays: String? = null,
    @SerialName("podcast_artist")
    val podcastArtist: String? = null,
    @SerialName("share_link")
    val shareLink: String? = null,
    @SerialName("short_date")
    val shortDate: String? = null,
    @SerialName("show_permlink")
    val showPermlink: String? = null,
    @SerialName("talk")
    val talk: Boolean? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("type")
    val type: String? = null
)