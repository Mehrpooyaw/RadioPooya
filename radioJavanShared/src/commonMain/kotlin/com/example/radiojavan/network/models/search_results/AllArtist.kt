package com.example.radiojavan.network.models.search_results


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllArtist(
    @SerialName("bg_colors")
    val bgColors: List<String?>? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("photo")
    val photo: String? = null,
    @SerialName("query")
    val query: String? = null,
    @SerialName("share_link")
    val shareLink: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("type")
    val type: String? = null
)