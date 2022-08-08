package com.example.radiojavan.network.models.track


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Related(
    @SerialName("album")
    val album: Album? = null,
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
    @SerialName("downloads")
    val downloads: String? = null,
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
    @SerialName("photo_player")
    val photoPlayer: String? = null,
    @SerialName("plays")
    val plays: String? = null,
    @SerialName("sample_start")
    val sampleStart: Int? = null,
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
    val type: String?
)