package com.example.radiojavan.network.models.artist


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Followers(
    @SerialName("count")
    val count: Int?,
    @SerialName("following")
    val following: Boolean?,
    @SerialName("plays")
    val plays: String?,
    @SerialName("show")
    val show: Boolean?
)