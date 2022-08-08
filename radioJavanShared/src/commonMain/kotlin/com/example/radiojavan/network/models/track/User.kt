package com.example.radiojavan.network.models.track


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("display_name")
    val displayName: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("username")
    val username: String? = null,
)