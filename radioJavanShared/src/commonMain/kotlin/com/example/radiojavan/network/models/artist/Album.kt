package com.example.radiojavan.network.models.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Album(
    @SerialName("album")
    val album: AlbumX?,
    @SerialName("album_album")
    val albumAlbum: String?,
    @SerialName("album_artist")
    val albumArtist: String?,
    @SerialName("album_id")
    val albumId: Int?,
    @SerialName("artist")
    val artist: String?,
    @SerialName("artist_farsi")
    val artistFarsi: String?,
    @SerialName("artist_tags")
    val artistTags: List<String>?,
    @SerialName("bg_colors")
    val bgColors: List<String>?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("dislikes")
    val dislikes: String?,
    @SerialName("downloads")
    val downloads: String?,
    @SerialName("duration")
    val duration: Double?,
    @SerialName("explicit")
    val explicit: Boolean?,
    @SerialName("hls_link")
    val hlsLink: String?,
    @SerialName("hq_hls")
    val hqHls: String?,
    @SerialName("hq_link")
    val hqLink: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("likes")
    val likes: String?,
    @SerialName("link")
    val link: String?,
    @SerialName("lq_hls")
    val lqHls: String?,
    @SerialName("lq_link")
    val lqLink: String?,
    @SerialName("lufs")
    val lufs: Double?,
    @SerialName("permlink")
    val permlink: String?,
    @SerialName("photo")
    val photo: String?,
    @SerialName("photo_240")
    val photo240: String?,
    @SerialName("photo_player")
    val photoPlayer: String?,
    @SerialName("plays")
    val plays: String?,
    @SerialName("sample_start")
    val sampleStart: Int?,
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
    val type: String?
)