package com.example.radiojavan.network.models.search_results


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Top(
    @SerialName("album")
    val album: AlbumX? = AlbumX(),
    @SerialName("album_album")
    val albumAlbum: String? = "",
    @SerialName("album_artist")
    val albumArtist: String? = "",
    @SerialName("album_id")
    val albumId: Int? = 0,
    @SerialName("artist")
    val artist: String? = "",
    @SerialName("artist_farsi")
    val artistFarsi: String? = "",
    @SerialName("artist_tags")
    val artistTags: List<String>? = listOf(),
    @SerialName("background_video_bg_color")
    val backgroundVideoBgColor: String? = "",
    @SerialName("background_video_hide_cover")
    val backgroundVideoHideCover: Boolean? = false,
    @SerialName("background_video_overlay_color")
    val backgroundVideoOverlayColor: String? = "",
    @SerialName("background_video_url")
    val backgroundVideoUrl: String? = "",
    @SerialName("bg_colors")
    val bgColors: List<String>? = listOf(),
    @SerialName("buy_link")
    val buyLink: String? = "",
    @SerialName("buy_text")
    val buyText: String? = "",
    @SerialName("created_at")
    val createdAt: String? = "",
    @SerialName("date")
    val date: String? = "",
    @SerialName("date_added")
    val dateAdded: String? = "",
    @SerialName("dislikes")
    val dislikes: String? = "",
    @SerialName("downloads")
    val downloads: String? = "",
    @SerialName("duration")
    val duration: Double? = 0.0,
    @SerialName("explicit")
    val explicit: Boolean? = false,
    @SerialName("high")
    val high: String? = "",
    @SerialName("high_web")
    val highWeb: String? = "",
    @SerialName("hls")
    val hls: String? = "",
    @SerialName("hls_link")
    val hlsLink: String? = "",
    @SerialName("hq_hls")
    val hqHls: String? = "",
    @SerialName("hq_link")
    val hqLink: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("likes")
    val likes: String? = "",
    @SerialName("link")
    val link: String? = "",
    @SerialName("low")
    val low: String? = "",
    @SerialName("low_web")
    val lowWeb: String? = "",
    @SerialName("lq_hls")
    val lqHls: String? = "",
    @SerialName("lq_link")
    val lqLink: String? = "",
    @SerialName("lufs")
    val lufs: Double? = 0.0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("permlink")
    val permlink: String? = "",
    @SerialName("photo")
    val photo: String? = "",
    @SerialName("photo_240")
    val photo240: String? = "",
    @SerialName("photo_large")
    val photoLarge: String? = "",
    @SerialName("photo_player")
    val photoPlayer: String? = "",
    @SerialName("plays")
    val plays: String? = "",
    @SerialName("podcast_artist")
    val podcastArtist: String? = "",
    @SerialName("query")
    val query: String? = "",
    @SerialName("sample_start")
    val sampleStart: Int? = 0,
    @SerialName("share_link")
    val shareLink: String? = "",
    @SerialName("short_date")
    val shortDate: String? = "",
    @SerialName("show_permlink")
    val showPermlink: String? = "",
    @SerialName("song")
    val song: String? = "",
    @SerialName("song_farsi")
    val songFarsi: String? = "",
    @SerialName("talk")
    val talk: Boolean? = false,
    @SerialName("thumbnail")
    val thumbnail: String? = "",
    @SerialName("title")
    val title: String? = "",
    @SerialName("type")
    val type: String? = "",
    @SerialName("views")
    val views: String? = ""
)