package com.example.radiojavan.network.models.home_items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Section(
    @SerialName("hide_icon")
    val hideIcon: Boolean?,
    @SerialName("id")
    val id: String?,
    @SerialName("items")
    val items: List<Item>?,
    @SerialName("link")
    val link: String?,
    @SerialName("playlist")
    val playlist: String?,
    @SerialName("show_link")
    val showLink: Boolean?,
    @SerialName("title")
    val title: String?,
    @SerialName("top_margin")
    val topMargin: Boolean?,
    @SerialName("type")
    val type: String?
)