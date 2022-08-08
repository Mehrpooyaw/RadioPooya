package com.example.radiojavan.network.models.home_items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("display_name")
    val displayName: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("username")
    val username: String?
)