package com.example.radiojavan.network.models.track


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Selfy(
    @SerialName("artist")
    val artist: String? = null,
    @SerialName("filename")
    val filename: String? = null,
    @SerialName("hash_id")
    val hashId: String? = null,
    @SerialName("hdvc")
    val hdvc: String? = null,
    @SerialName("hls")
    val hls: String? = null,
    @SerialName("hq_link")
    val hqLink: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("likes")
    val likes: String? = null,
    @SerialName("likes_pretty")
    val likesPretty: String? = null,
    @SerialName("link")
    val link: String? = null,
    @SerialName("location")
    val location: String? = null,
    @SerialName("mp3")
    val mp3: Int? = null,
    @SerialName("photo")
    val photo: String? = null,
    @SerialName("share_link")
    val shareLink: String? = null,
    @SerialName("song")
    val song: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("user")
    val user: User? = null,
    @SerialName("verified")
    val verified: Boolean? = false
)