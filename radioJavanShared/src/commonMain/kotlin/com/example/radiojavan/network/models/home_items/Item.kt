package com.example.radiojavan.network.models.home_items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
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
    @SerialName("bg_color")
    val bgColor: String?,
    @SerialName("bg_colors")
    val bgColors: List<String>?,
    @SerialName("count")
    val count: Int?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("created_by")
    val createdBy: String?,
    @SerialName("custom_photo")
    val customPhoto: Boolean?,
    @SerialName("desc")
    val desc: String?,
    @SerialName("dislikes")
    val dislikes: String?,
    @SerialName("downloads")
    val downloads: String?,
    @SerialName("duration")
    val duration: Double?,
    @SerialName("explicit")
    val explicit: Boolean?,
    @SerialName("filename")
    val filename: String?,
    @SerialName("followers")
    val followers: Int?,
    @SerialName("hash_id")
    val hashId: String?,
    @SerialName("hdvc")
    val hdvc: String?,
    @SerialName("hls")
    val hls: String?,
    @SerialName("hls_link")
    val hlsLink: String?,
    @SerialName("hq_hls")
    val hqHls: String?,
    @SerialName("hq_link")
    val hqLink: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("item")
    val item: ItemX?,
    @SerialName("items_count")
    val itemsCount: Int?,
    @SerialName("last_updated_at")
    val lastUpdatedAt: String?,
    @SerialName("likes")
    val likes: String?,
    @SerialName("likes_pretty")
    val likesPretty: String?,
    @SerialName("link")
    val link: String?,
    @SerialName("link_title")
    val linkTitle: String?,
    @SerialName("location")
    val location: String?,
    @SerialName("lq_hls")
    val lqHls: String?,
    @SerialName("lq_link")
    val lqLink: String?,
    @SerialName("lufs")
    val lufs: Double?,
    @SerialName("mp3")
    val mp3: Int?,
    @SerialName("myplaylist")
    val myplaylist: Boolean?,
    @SerialName("name")
    val name: String?,
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
    @SerialName("public")
    val `public`: Boolean?,
    @SerialName("query")
    val query: String?,
    @SerialName("sample_start")
    val sampleStart: Int?,
    @SerialName("share_link")
    val shareLink: String?,
    @SerialName("song")
    val song: String?,
    @SerialName("song_farsi")
    val songFarsi: String?,
    @SerialName("subtitle")
    val subtitle: String?,
    @SerialName("subtype")
    val subtype: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("user")
    val user: User?,
    @SerialName("verified")
    val verified: Boolean?
)